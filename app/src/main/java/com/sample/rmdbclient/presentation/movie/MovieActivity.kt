package com.sample.rmdbclient.presentation.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sample.rmdbclient.R
import com.sample.rmdbclient.databinding.ActivityMoviesBinding

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoviesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movies)
    }
}