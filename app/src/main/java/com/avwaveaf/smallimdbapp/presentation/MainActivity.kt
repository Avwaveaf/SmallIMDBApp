package com.avwaveaf.smallimdbapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.avwaveaf.smallimdbapp.R
import com.avwaveaf.smallimdbapp.databinding.ActivityMainBinding
import com.avwaveaf.smallimdbapp.presentation.artist.ArtistActivity
import com.avwaveaf.smallimdbapp.presentation.movie.MovieActivity
import com.avwaveaf.smallimdbapp.presentation.tvshow.TvShowActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setupBinding()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        setupBtnClickListener()
    }

    private fun setupBtnClickListener() {
        binding.apply {
            btnMovies.setOnClickListener {
                createNewIntentThenStartActivity(MovieActivity::class.java)
            }
            btnArtist.setOnClickListener {
                createNewIntentThenStartActivity(ArtistActivity::class.java)
            }
            btnTvShow.setOnClickListener {
                createNewIntentThenStartActivity(TvShowActivity::class.java)
            }
        }
    }

    private fun createNewIntentThenStartActivity(targetCls: Class<*>) {
        val intent = Intent(this, targetCls)
        startActivity(intent)
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }



}