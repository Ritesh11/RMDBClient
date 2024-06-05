package com.sample.rmdbclient.data.repository.movie

import com.sample.rmdbclient.data.model.movies.Movie
import com.sample.rmdbclient.domain.repository.MovieRepository

class FakeMovieRepository: MovieRepository {

    private val movies = mutableListOf<Movie>()

    init {
        movies.add(Movie(1,"Overview1","PosterPath1", "Title1", "ReleaseDate1"))
        movies.add(Movie(2,"Overview2","PosterPath2", "Title2", "ReleaseDate2"))
        movies.add(Movie(3,"Overview3","PosterPath3", "Title3", "ReleaseDate3"))
    }

    override suspend fun getMovies(): List<Movie>? {
        return movies
    }

    override suspend fun updateMovies(): List<Movie>? {
        movies.clear()
        movies.add(Movie(4,"Overview4","PosterPath4", "Title4", "ReleaseDate4"))
        movies.add(Movie(5,"Overview5","PosterPath5", "Title5", "ReleaseDate5"))
        movies.add(Movie(6,"Overview6","PosterPath6", "Title6", "ReleaseDate6"))

        return movies
    }
}