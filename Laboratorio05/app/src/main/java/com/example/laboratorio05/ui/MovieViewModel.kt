package com.example.laboratorio05.ui

import android.text.Spannable.Factory
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.fragment.findNavController
import com.example.laboratorio05.MovieReviewerApplication
import com.example.laboratorio05.data.model.Movie_model
import com.example.laboratorio05.repository.MovieRepository

class MovieViewModel(private val repository: MovieRepository): ViewModel() {
    var name : MutableLiveData<String> = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")

    fun getMovies()= repository.getMovie()// llama a repository y le pase la lista
    fun addMovie(movie:Movie_model)= repository.addMovie(movie)

    private fun validarData():Boolean{
        when{
            name.value.isNullOrEmpty()->return false
            category.value.isNullOrEmpty()->return false
            description.value.isNullOrEmpty()->return false
            qualification.value.isNullOrEmpty()->return false
        }
        return true
    }

     fun createMovie(){
    if(!validarData()){
        status.value = WRONG_DATA
        return
    }
        val newMovie = Movie_model(
            name.value.toString(),
            category.value.toString(),
            description.value.toString(),
            qualification.value.toString()
        )
        addMovie(newMovie)
         status.value = MOVIE_CREATED
    }
    fun clearData(){
        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
    }
    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }

        const val MOVIE_CREATED = "Movie created"
        const val WRONG_DATA = "Wrong data"
        const val INACTIVE = ""
    }
    fun clearStatus(){
        status.value = INACTIVE
    }
}