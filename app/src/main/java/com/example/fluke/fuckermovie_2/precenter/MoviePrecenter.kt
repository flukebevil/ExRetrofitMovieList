package com.example.fluke.fuckermovie_2.precenter

import com.example.fluke.fuckermovie_2.Contactor
import com.example.fluke.fuckermovie_2.fragment.ListViewFragment
import com.example.fluke.fuckermovie_2.model.CallData
import com.example.fluke.fuckermovie_2.model.Movie
import com.example.fluke.fuckermovie_2.model.MovieList

class MoviePrecenter : Contactor.Precenter {
    lateinit var data: ArrayList<MovieList>
    lateinit var model: Contactor.Model
    lateinit var view: Contactor.view

    override fun reciever(arr: ArrayList<Movie>?) {
        view = ListViewFragment()
        view.fragmentData(arr)
    }

    override fun createPrecenter() {
        model = CallData()
        model.dataCallBack()
    }
}