package com.sample.rmdbclient.presentation.movie

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.rmdbclient.R
import com.sample.rmdbclient.databinding.ActivityMoviesBinding
import com.sample.rmdbclient.presentation.di.Injector
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel

    private lateinit var binding: ActivityMoviesBinding
    private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movies)
        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)

        initRecyclerView()
    }

    fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayMovies()
    }

    fun displayMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val response = movieViewModel.getMovies()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                Toast.makeText(this,"No data available",Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this,Observer{
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
            }
        })
    }
}