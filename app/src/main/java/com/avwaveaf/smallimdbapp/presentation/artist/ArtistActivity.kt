package com.avwaveaf.smallimdbapp.presentation.artist

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
import com.avwaveaf.smallimdbapp.data.model.artist.Artist
import com.avwaveaf.smallimdbapp.databinding.ActivityArtistBinding
import com.avwaveaf.smallimdbapp.databinding.ListItemBinding
import com.avwaveaf.smallimdbapp.presentation.GenericRecyclerViewAdapter
import com.avwaveaf.smallimdbapp.presentation.di.Injector
import com.bumptech.glide.Glide
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel

    private lateinit var binding: ActivityArtistBinding

    // list adapter
    private lateinit var artistAdapter: GenericRecyclerViewAdapter<Artist, ListItemBinding>

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
        initRecylerView()
    }

    private fun initRecylerView() {
        binding.artistRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ArtistActivity)
            adapter = artistAdapter
        }

        displayArtists()
    }

    private fun setupListAdapter() {
        artistAdapter = GenericRecyclerViewAdapter(
            R.layout.list_item,
            bind = { binding, artist ->
                val profileUrl = "https://image.tmdb.org/t/p/w500${artist.profilePath}"
                Glide.with(binding.itemImage.context)
                    .load(profileUrl)
                    .into(binding.itemImage)
                binding.apply {
                    itemTitle.text = artist.name
                    itemDescription.text = artist.knownForDepartment
                }
            },
            areItemsTheSameCondition = { oldItem, newItem -> oldItem.id == newItem.id },
            areContentsTheSameCondition = { oldContent, newContent ->
                oldContent.popularity == newContent.popularity
            }
        )
    }

    private fun displayArtists() {
        binding.progressBar2.visibility = View.VISIBLE

        val res = artistViewModel.getArtists()
        res.observe(this, Observer {
            if (it != null) {
                artistAdapter.submitList(it)
                binding.progressBar2.visibility = View.GONE
            } else {
                binding.progressBar2.visibility = View.GONE
                Toast.makeText(applicationContext, "There is No Data shown!", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    private fun setupViewModel() {
        (application as Injector).createArtistSubComponent().inject(this)
        artistViewModel = ViewModelProvider(this, factory)[ArtistViewModel::class.java]
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateArtist()
                true
            }
            else-> super.onOptionsItemSelected(item)
        }

    }

    private fun updateArtist() {
        binding.progressBar2.visibility = View.VISIBLE

        val res = artistViewModel.updateArtists()
        res.observe(this, Observer {
            if (it != null) {
                artistAdapter.submitList(it)
                binding.progressBar2.visibility = View.GONE
            } else {
                binding.progressBar2.visibility = View.GONE
                Toast.makeText(applicationContext, "There is No Data shown!", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }


}