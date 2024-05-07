package com.sample.rmdbclient.data.api

import com.sample.rmdbclient.data.api.model.artist.ArtistList
import com.sample.rmdbclient.data.api.model.movies.MovieList
import com.sample.rmdbclient.data.api.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RMDBService {

    @GET("movie/11")
    suspend fun getTrendingMovie(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("trending/tv")
    suspend fun getTrendingTvShows(@Query("api_key") apiKey: String): Response<TvShowList>


    @GET("trending/person")
    suspend fun getTrendingArtist(@Query("api_key") apiKey: String): Response<ArtistList>
}