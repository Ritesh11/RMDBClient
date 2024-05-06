package com.sample.rmdbclient.presentation.artist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sample.rmdbclient.R
import com.sample.rmdbclient.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
    }
}