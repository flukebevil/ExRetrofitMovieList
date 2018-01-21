package com.example.fluke.fuckermovie_2.model

import com.example.fluke.fuckermovie_2.Contactor
import com.example.fluke.fuckermovie_2.precenter.MoviePrecenter

class CallData:Contactor.Model {
    val precenter: Contactor.Precenter = MoviePrecenter()
    var list: ArrayList<Movie>? = ArrayList()

    override fun dataCallBack(params: String) {

    }
}