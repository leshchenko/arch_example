package com.leshchenko.movies.ui.movies_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.leshchenko.movies.databinding.MovieListItemBinding
import com.leshchenko.movies.ui.movies_list.model.MovieModelView

class MoviesAdapter(private val itemClick: (movieId: Int) -> Unit) :
    ListAdapter<MovieModelView, MoviesAdapter.MovieViewHolder>(movieItemDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            MovieListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MovieViewHolder(private val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieModelView) {
            binding.movieNameTextView.text = movie.name
            binding.root.setOnClickListener { itemClick(movie.id) }
        }
    }

    companion object {
        private val movieItemDiffCallback = object : DiffUtil.ItemCallback<MovieModelView>() {
            override fun areItemsTheSame(
                oldItem: MovieModelView,
                newItem: MovieModelView
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: MovieModelView,
                newItem: MovieModelView
            ): Boolean = oldItem.name == newItem.name
        }
    }
}