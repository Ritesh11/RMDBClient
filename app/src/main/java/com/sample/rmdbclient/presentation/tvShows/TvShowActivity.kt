package com.sample.rmdbclient.presentation.tvShows

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
import com.sample.rmdbclient.databinding.ActivityTvShowBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TvShowActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: TvShowsViewModelFactory

    private lateinit var binding: ActivityTvShowBinding
    private lateinit var adapter: TvShowAdapter
    private lateinit var tvShowsViewModel: TvShowsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        tvShowsViewModel = ViewModelProvider(this, factory).get(TvShowsViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.tvShowsRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.tvShowsRecyclerView.adapter = adapter
        displayTvShows()
    }

    private fun displayTvShows() {
        binding.tvShowsProgressBar.visibility = View.VISIBLE
        val response = tvShowsViewModel.getTvShows()
        response.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowsProgressBar.visibility = View.GONE
            } else {
                binding.tvShowsProgressBar.visibility = View.GONE
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
                updateTvShows()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShows() {
        binding.tvShowsProgressBar.visibility = View.VISIBLE
        val response = tvShowsViewModel.updateTvShows()
        response.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowsProgressBar.visibility = View.GONE
            } else {
                binding.tvShowsProgressBar.visibility = View.GONE
                Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show()
            }
        }
    }
}