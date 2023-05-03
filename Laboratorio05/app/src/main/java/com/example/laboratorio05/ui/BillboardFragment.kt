package com.example.laboratorio05.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.example.laboratorio05.R
import com.example.laboratorio05.databinding.FragmentBillboardBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {
    lateinit var binding : FragmentBillboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.starWarsCardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        }

        binding.harryPotterCardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        }

        binding.btnNavCreateNewMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }

    }

}