package com.example.fluke.fuckermovie_2.precenter

import com.example.fluke.fuckermovie_2.Contactor
import com.example.fluke.fuckermovie_2.model.Movie

class MoviePrecenter : Contactor.Precenter {
    var data: ArrayList<Movie>? = null
    lateinit var view: Contactor.view
}