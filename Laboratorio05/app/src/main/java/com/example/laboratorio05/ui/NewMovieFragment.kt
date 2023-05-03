package com.example.laboratorio05.ui

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.Movie_model
import com.example.laboratorio05.databinding.FragmentNewMovieBinding

class NewMovieFragment : Fragment() {

    private lateinit var binding: FragmentNewMovieBinding
    private val viewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNewMovieBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observerStatus()

    }
    private fun setViewModel(){
        binding.viewmodel = viewModel
    }
private fun observerStatus (){
    viewModel.status.observe(viewLifecycleOwner){ status ->
        when{
            status.equals(MovieViewModel.MOVIE_CREATED)->{
                Log.d("APP TAG", status)
                Log.d("APP TAG", viewModel.getMovies().toString())

                viewModel.clearStatus()
                viewModel.clearData()
                findNavController().popBackStack()
            }
            status.equals(MovieViewModel.WRONG_DATA)->{
                Log.d("APP TAG",status)
                viewModel.clearStatus()
            }
        }

    }
}
}