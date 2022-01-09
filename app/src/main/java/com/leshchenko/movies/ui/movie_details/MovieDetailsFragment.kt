package com.leshchenko.movies.ui.movie_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.leshchenko.movies.databinding.FragmentSecondBinding
import com.leshchenko.movies.ext.observeWithLifecycle
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class MovieDetailsFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    private val arguments by navArgs<MovieDetailsFragmentArgs>()
    private val viewModel by viewModel<MovieDetailsViewModel> { parametersOf(arguments.movieId) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.movieDetailsFlow.observeWithLifecycle(viewLifecycleOwner) {
            binding.dataTextView.text = it.toString()
        }
    }
}