package com.avwaveaf.smallimdbapp.presentation.tvshow

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
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.avwaveaf.smallimdbapp.R
import com.avwaveaf.smallimdbapp.data.model.tvshow.TvShow
import com.avwaveaf.smallimdbapp.databinding.ActivityTvShowBinding
import com.avwaveaf.smallimdbapp.databinding.ListItemBinding
import com.avwaveaf.smallimdbapp.presentation.GenericRecyclerViewAdapter
import com.avwaveaf.smallimdbapp.presentation.di.Injector
import com.bumptech.glide.Glide
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel

    private lateinit var tvShowAdapter: GenericRecyclerViewAdapter<TvShow, ListItemBinding>

    private lateinit var binding: ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setupBinding()
        setupViewModel()
        setSupportActionBar(binding.toolbar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupListAdapter()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = tvShowAdapter
        }

        displayTvShows()
    }

    private fun displayTvShows() {
        binding.progressBar3.visibility = View.VISIBLE

        val res = tvShowViewModel.getTvShows()
        res.observe(this, Observer {
            if (it != null) {
                tvShowAdapter.submitList(it)
                binding.progressBar3.visibility = View.GONE
            } else {
                binding.progressBar3.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupListAdapter() {
        tvShowAdapter = GenericRecyclerViewAdapter(
            R.layout.list_item,
            bind = { binding, tvShow ->
                val posterPath = "https://image.tmdb.org/t/p/w500${tvShow.posterPath}"
                Glide.with(binding.itemImage.context)
                    .load(posterPath)
                    .into(binding.itemImage)
                binding.apply {
                    itemTitle.text = tvShow.name
                    itemDescription.text = tvShow.overview
                }
            },
            areItemsTheSameCondition = { oldItem, newItem -> oldItem.id == newItem.id },
            areContentsTheSameCondition = { oldItem, newItem ->
                oldItem.name == newItem.name
                        && oldItem.voteCount == newItem.voteCount
            }
        )
    }

    private fun setupViewModel() {
        (application as Injector).createTvShowSubComponent().inject(this)
        tvShowViewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateTvShow()
                true
            }
            else-> super.onOptionsItemSelected(item)
        }

    }

    private fun updateTvShow() {
        binding.progressBar3.visibility = View.VISIBLE

        val res = tvShowViewModel.updateTvShows()
        res.observe(this, Observer {
            if (it != null) {
                tvShowAdapter.submitList(it)
                binding.progressBar3.visibility = View.GONE
            } else {
                binding.progressBar3.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_SHORT).show()
            }
        })
    }
}