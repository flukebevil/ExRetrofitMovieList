package com.example.fluke.fuckermovie2.moviedetail

import com.example.fluke.fuckermovie2.moviedetail.model.YouVidData

interface Contractor {
    interface Vid {
        fun vidView(arr: ArrayList<YouVidData>?)
    }

    interface VidPresenter {
        fun vidPresenter(key: String?)
    }
}