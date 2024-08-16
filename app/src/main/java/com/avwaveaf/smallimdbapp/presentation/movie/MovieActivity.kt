package com.avwaveaf.smallimdbapp.presentation.movie

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.avwaveaf.smallimdbapp.R
import com.avwaveaf.smallimdbapp.databinding.ActivityMovieBinding
import com.avwaveaf.smallimdbapp.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel

    private lateinit var binding: ActivityMovieBinding

    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setupBinding()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        (application as Injector).createMovieSubComponent().inject(this)
        setSupportActionBar(binding.toolbar)

        setupMovieViewModel()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.moviesRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@MovieActivity)
            adapter = movieAdapter
        }
        displayMovies()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayMovies() {
        binding.progressBar.visibility = View.VISIBLE

        val res = movieViewModel.getMovies()
        res.observe(this, Observer {
            if (it != null) {
                movieAdapter.setList(it)
                movieAdapter.notifyDataSetChanged()
                // remove progress bar
                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupMovieViewModel() {
        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)

    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        movieAdapter = MovieAdapter()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }
            else-> super.onOptionsItemSelected(item)
        }

    }

    private fun updateMovies() {
        binding.progressBar.visibility = View.VISIBLE
        val res = movieViewModel.updateMovies()
        res.observe(this, Observer {
            if (it != null) {
                movieAdapter.setList(it)
                movieAdapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "Movie has No Update", Toast.LENGTH_SHORT).show()
            }
        })
    }

}