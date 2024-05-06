package com.sample.rmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sample.rmdbclient.data.api.model.tvshow.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(artists: List<TvShow>)

    @Query("Delete from trending_tvShows")
    suspend fun deleteAllTvShows()

    @Query("Select * From trending_tvShows")
    suspend fun getTvShows(): List<TvShow>
}