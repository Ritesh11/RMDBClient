package com.sample.rmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sample.rmdbclient.data.api.model.movies.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("Delete from trending_movies")
    suspend fun deleteAllMovies()

    @Query("Select * From trending_movies")
    suspend fun getMovies(): List<Movie>

}