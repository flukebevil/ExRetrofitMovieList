package com.example.fluke.fuckermovie2.moviedetail.model

import android.util.Log
import com.example.fluke.fuckermovie2.moviedetail.DetailActor
import com.example.fluke.fuckermovie2.network.BaseUrl
import com.example.fluke.fuckermovie2.network.WTFManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InterActies: DetailActor.ActData {
    override fun callVidData(key: String?, callback: DetailActor.OnVidCallBackListener) {
        WTFManager.Factory.create(BaseUrl.baseYouUrl)?.searchVid(key ?: "")?.enqueue(object : Callback<VidListFOF> {
            override fun onResponse(call: Call<VidListFOF>?, response: Response<VidListFOF>?) {
                Log.e("awefawefawefaweeeeeeeee", response?.body()?.toString())
                callback.onSuccess(response?.body()?.results)
            }

            override fun onFailure(call: Call<VidListFOF>?, t: Throwable?) {
                Log.e("awefawefawefaweeeeeeeee", t.toString())
            }
        })
    }
}