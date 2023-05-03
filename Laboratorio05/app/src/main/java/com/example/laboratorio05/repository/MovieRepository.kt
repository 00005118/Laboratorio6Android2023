package com.example.laboratorio05.repository

import com.example.laboratorio05.data.model.Movie_model

class MovieRepository (private val movie: MutableList<Movie_model>) {

    fun getMovie()=movie
    fun addMovie(newMovie: Movie_model)= movie.add(newMovie)
}