package com.sample.rmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sample.rmdbclient.data.api.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artists: List<Artist>)

    @Query("Delete from trending_artists")
    suspend fun deleteAllArtists()

    @Query("Select * From trending_artists")
    suspend fun getArtists(): List<Artist>
}