package com.example.fluke.fuckermovie2.model

import android.util.Log
import com.example.fluke.fuckermovie2.InterActor
import com.example.fluke.fuckermovie2.moviedetail.model.VidListFOF
import com.example.fluke.fuckermovie2.network.BaseUrl
import com.example.fluke.fuckermovie2.network.WTFManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InterActies : InterActor.ActData {

    override fun callPopular(callback: InterActor.OnFinishedListener) {
        WTFManager.Factory.create(BaseUrl.baseUrl)?.popular()?.enqueue(object : Callback<MovieList>{
            override fun onFailure(call: Call<MovieList>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<MovieList>?, response: Response<MovieList>?) {
                Log.e("nanungHee" , response?.body().toString())
                callback.onSuccess(response?.body()?.results)
            }

        })

    }

    override fun callDataWtf(key: String?, callback: InterActor.OnFinishedListener) {
        WTFManager.Factory.create(BaseUrl.baseUrl)?.search(key
                ?: "")?.enqueue(object : Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<MovieList>?, response: Response<MovieList>?) {
                if (response != null) {
                    // TODO callback to view
                    callback.onSuccess(response.body()?.results)
                }
            }
        })
    }
}