package com.example.fluke.fuckermovie2.moviedetail

import com.example.fluke.fuckermovie2.moviedetail.model.YouVidData

interface DetailActor{
    interface ActData {
        fun callVidData(key: String?, callback: DetailActor.OnVidCallBackListener)
    }
    interface OnVidCallBackListener {
        fun onSuccess(results: ArrayList<YouVidData>?)
    }
}