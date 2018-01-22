package com.example.fluke.fuckermovie2

import com.example.fluke.fuckermovie2.model.Movie

interface Contactor {

    interface Precenter {
        fun testPresenter(key: String? , view : Contactor.view)
        fun dateFormat(date: String?): String
        fun recieveData(arr: ArrayList<Movie>? , view: Contactor.view)
    }

    interface view {
        fun fragmentData(arr: ArrayList<Movie>?)
    }

    interface Model {
        fun callDataWtf(key:String? , view: Contactor.view)
    }

}

