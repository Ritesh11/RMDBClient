package com.sample.rmdbclient.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.sample.rmdbclient.data.model.movies.Movie
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instanceTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var doa: MovieDao
    private lateinit var database: RMDBDatabase

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            RMDBDatabase::class.java
        ).build()
        doa = database.movieDao()
    }


    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun saveMovieTest(): Unit = runBlocking {
        val movies = listOf(
            Movie(1, "Overview1", "PosterPath1", "releaseDate1", "title1"),
            Movie(2, "Overview2", "PosterPath2", "releaseDate2", "title2"),
            Movie(3, "Overview3", "PosterPath3", "releaseDate3", "title3")
        )

        doa.saveMovies(movies)

        val allMovies = doa.getMovies()

        Truth.assertThat(allMovies).isEqualTo(movies)
    }

    @Test
    fun deleteAllMovieTest(): Unit = runBlocking {
        val movies = listOf(
            Movie(1, "Overview1", "PosterPath1", "releaseDate1", "title1"),
            Movie(2, "Overview2", "PosterPath2", "releaseDate2", "title2"),
            Movie(3, "Overview3", "PosterPath3", "releaseDate3", "title3")
        )

        doa.saveMovies(movies)

        val allMovies = doa.deleteAllMovies()
        val movieResult = doa.getMovies()

        Truth.assertThat(movieResult).isEmpty()
    }
}
