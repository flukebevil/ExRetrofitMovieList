package com.example.fluke.fuckermovie2

import com.example.fluke.fuckermovie2.model.Movie

interface Contractor {
    interface Presenter {
        fun callDownData(key: String?)
    }

    interface View {
        fun fragmentData(arr: ArrayList<Movie>?)
    }
}

