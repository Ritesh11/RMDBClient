package com.sample.rmdbclient.data.repository.artist

import android.util.Log
import com.sample.rmdbclient.data.api.model.artist.Artist
import com.sample.rmdbclient.data.repository.artist.dataSource.ArtistCacheDataSource
import com.sample.rmdbclient.data.repository.artist.dataSource.ArtistLocalDataSource
import com.sample.rmdbclient.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.sample.rmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newArtists = getArtistFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDb(newArtists)
        artistCacheDataSource.saveArtistsToCache(newArtists)
        return newArtists
    }

    private suspend fun getArtistFromApi(): List<Artist> {
        lateinit var artists: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artists = body.artists
            }
        } catch (e: Exception) {
            Log.e("MyTag", e.message.toString())
        }

        return artists
    }

    private suspend fun getArtistFromDb(): List<Artist> {
        lateinit var artists: List<Artist>

        try {
            artists = artistLocalDataSource.getArtistsFromDB()
        } catch (e: Exception) {
            Log.e("MyTag", e.message.toString())
        }

        if (artists.size > 0) {
            return artists
        } else {
            artists = getArtistFromApi()
            artistLocalDataSource.saveArtistsToDb(artists)
        }

        return artists
    }

    private suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artists: List<Artist>

        try {
            artists = artistCacheDataSource.getArtistsFromCache()
        } catch (e: Exception) {
            Log.e("MyTag", e.message.toString())
        }

        if(artists.isNotEmpty()){
            return artists
        }else{
            artists = getArtistFromDb()
            artistCacheDataSource.saveArtistsToCache(artists)
        }

        return artists
    }
}