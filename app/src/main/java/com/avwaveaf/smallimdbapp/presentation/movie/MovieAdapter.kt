package com.avwaveaf.smallimdbapp.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.avwaveaf.smallimdbapp.R
import com.avwaveaf.smallimdbapp.data.model.movie.Movie
import com.avwaveaf.smallimdbapp.databinding.ListItemBinding
import com.bumptech.glide.Glide

class MovieAdapter() : RecyclerView.Adapter<MovieViewHolder>() {
    private val movieList = ArrayList<Movie>()

    fun setList(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListItemBinding>(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MovieViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

}

class MovieViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        val posterUrl = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
        Glide.with(binding.itemImage.context)
            .load(posterUrl)
            .into(binding.itemImage)
        binding.apply {
            itemTitle.text = movie.title
            itemDescription.text = movie.overview
        }

    }

}