package com.sample.rmdbclient.data.repository.artist.dataSourceImpl

import com.sample.rmdbclient.data.model.artist.Artist
import com.sample.rmdbclient.data.db.ArtistDao
import com.sample.rmdbclient.data.repository.artist.dataSource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val dao: ArtistDao) : ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist>{
        return dao.getArtists()
    }

    override suspend fun saveArtistsToDb(newArtists: List<Artist>) {
        CoroutineScope(IO).launch {
            dao.saveArtist(newArtists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            dao.deleteAllArtists()
        }
    }
}