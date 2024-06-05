package com.sample.rmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.sample.rmdbclient.data.model.movies.Movie
import com.sample.rmdbclient.data.repository.movie.FakeMovieRepository
import com.sample.rmdbclient.domain.useCase.movieUseCase.GetMoviesUseCase
import com.sample.rmdbclient.domain.useCase.movieUseCase.UpdateMovieUseCase
import com.sample.rmdbclient.getOrAwaitValue

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMovieUseCase = UpdateMovieUseCase(fakeMovieRepository)

        viewModel = MovieViewModel(getMoviesUseCase, updateMovieUseCase)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getMovies_returnsCurrentList() {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1,"Overview1","PosterPath1", "Title1", "ReleaseDate1"))
        movies.add(Movie(2,"Overview2","PosterPath2", "Title2", "ReleaseDate2"))
        movies.add(Movie(3,"Overview3","PosterPath3", "Title3", "ReleaseDate3"))

        val currentList = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnsUpdatedList() {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(4,"Overview4","PosterPath4", "Title4", "ReleaseDate4"))
        movies.add(Movie(5,"Overview5","PosterPath5", "Title5", "ReleaseDate5"))
        movies.add(Movie(6,"Overview6","PosterPath6", "Title6", "ReleaseDate6"))

        val updatedList = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)
    }


}