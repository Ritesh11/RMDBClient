package com.sample.rmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sample.rmdbclient.data.api.model.artist.Artist
import com.sample.rmdbclient.data.api.model.movies.Movie
import com.sample.rmdbclient.data.api.model.tvshow.TvShow
import com.sample.rmdbclient.data.db.ArtistDao
import com.sample.rmdbclient.data.db.MovieDao
import com.sample.rmdbclient.data.db.TvShowDao

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class RMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}