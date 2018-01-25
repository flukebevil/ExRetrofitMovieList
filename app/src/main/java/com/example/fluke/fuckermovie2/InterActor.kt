package com.example.fluke.fuckermovie2

import com.example.fluke.fuckermovie2.model.Movie

interface InterActor {
    interface OnFinishedListener {
        fun onSuccess(results: ArrayList<Movie>?)
    }
    interface ActData {
        fun callPopular(callback: InterActor.OnFinishedListener)
        fun callDataWtf(key: String?, callback: InterActor.OnFinishedListener)
    }
}