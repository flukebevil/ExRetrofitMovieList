package com.example.fluke.fuckermovie_2

import android.os.Bundle
import com.example.fluke.fuckermovie_2.model.Movie

interface Contactor{
    interface Precenter{
    }

    interface view{
        fun fragmentData(arr: ArrayList<Movie>?){}
    }

    interface Model{
        fun dataCallBack(params : String)
    }

}

