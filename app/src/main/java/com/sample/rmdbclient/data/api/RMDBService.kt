package com.sample.rmdbclient.data.api

import com.sample.rmdbclient.data.model.artist.ArtistList
import com.sample.rmdbclient.data.model.movies.MovieList
import com.sample.rmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RMDBService {

    @GET("movie/popular")
    suspend fun getTrendingMovie(
        @Query("api_key") apiKey: String
    ): Response<MovieList>

    @GET("tv/popular")
    suspend fun getTrendingTvShows(@Query("api_key") apiKey: String): Response<TvShowList>


    @GET("person/popular")
    suspend fun getTrendingArtist(@Query("api_key") apiKey: String): Response<ArtistList>
}