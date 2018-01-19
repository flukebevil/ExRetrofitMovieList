package com.example.fluke.fuckermovie_2

import com.example.fluke.fuckermovie_2.model.Movie

interface Contactor{
    interface Precenter{
       fun reciever(arr: ArrayList<Movie>? =null)
       fun createPrecenter()
    }
    interface view{
        fun fragmentData(arr: ArrayList<Movie>?){}
    }

    interface Model{
        fun dataCallBack()
    }

}

