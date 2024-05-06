package com.sample.rmdbclient.presentation.tvShows

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sample.rmdbclient.R
import com.sample.rmdbclient.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
    }
}