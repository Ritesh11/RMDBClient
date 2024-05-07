package com.sample.rmdbclient.presentation.movie

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sample.rmdbclient.R
import com.sample.rmdbclient.databinding.ActivityMoviesBinding
import com.sample.rmdbclient.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel

    private lateinit var binding: ActivityMoviesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movies)
        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)

        val response = movieViewModel.getMovies()
        response.observe(this, Observer {
            Log.i("MyTag", it.toString())
        })
    }
}