package com.sample.rmdbclient.presentation.artist

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.rmdbclient.R
import com.sample.rmdbclient.databinding.ActivityArtistBinding
import com.sample.rmdbclient.presentation.di.Injector
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var binding: ActivityArtistBinding
    private lateinit var viewModel: ArtistViewModel
    private lateinit var artistAdapter: ArtistAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)
        viewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)
        intiRecyclerView()
    }


    private fun intiRecyclerView() {
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        artistAdapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = artistAdapter
        displayArtists()
    }

    private fun displayArtists() {
        binding.artistProgressBar.visibility = View.VISIBLE

        var response = viewModel.getArtist()
        response.observe(this) {
            if (it != null) {
                artistAdapter.setList(it)
                artistAdapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                refreshArtists()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun refreshArtists() {
        binding.artistProgressBar.visibility = View.VISIBLE

        var response = viewModel.updateArtist()
        response.observe(this) {
            if (it != null) {
                artistAdapter.setList(it)
                artistAdapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show()
            }
        }
    }

}