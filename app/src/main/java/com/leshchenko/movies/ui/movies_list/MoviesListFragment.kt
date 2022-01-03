package com.leshchenko.movies.ui.movies_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.leshchenko.movies.databinding.FragmentFirstBinding
import com.leshchenko.movies.ext.observeWithLifecycle
import org.koin.androidx.viewmodel.ext.android.viewModel


class MoviesListFragment : Fragment() {

    private var binding: FragmentFirstBinding? = null
    private val viewModel by viewModel<MoviesListViewModel>()
    private val adapter = MoviesAdapter { movieId ->
        findNavController().navigate(MoviesListFragmentDirections.toMovieDetails(movieId))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.moviesRecyclerView?.adapter = adapter
        viewModel.moviesList.observeWithLifecycle(viewLifecycleOwner) {
            binding?.progressBar?.isVisible = false
            adapter.submitList(it)
        }
    }
}