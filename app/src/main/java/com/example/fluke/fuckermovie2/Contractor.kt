package com.example.fluke.fuckermovie2

import com.example.fluke.fuckermovie2.model.Movie
import com.example.fluke.fuckermovie2.model.YouVidData

interface Contractor {

    interface Presenter {
        fun testPresenter(key: String?)
        fun dateFormat(date: String?): String
        interface VidPresenter {
            fun vidPresenter(key: String?)
        }
    }

    interface View {
        fun fragmentData(arr: ArrayList<Movie>?)
        interface Vid {
            fun vidView(arr: ArrayList<YouVidData>?)
        }
    }

    interface Model {
        interface OnFinishedListener {
            fun onSuccess(results: ArrayList<Movie>?)
        }

        interface OnVidCallBackListener {
            fun onSuccess(results: ArrayList<YouVidData>?)
        }

        fun callDataWtf(key: String?, callback: OnFinishedListener)
        fun callVidData(key: String?, callback: OnVidCallBackListener)
    }

}

