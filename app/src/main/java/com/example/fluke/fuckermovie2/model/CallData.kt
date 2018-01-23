package com.example.fluke.fuckermovie2.model

import android.util.Log
import com.example.fluke.fuckermovie2.Contractor
import com.example.fluke.fuckermovie2.network.BaseUrl
import com.example.fluke.fuckermovie2.network.WTFManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallData : Contractor.Model {

    override fun callVidData(key: String?, callback: Contractor.Model.OnVidCallBackListener) {
        WTFManager.Factory.create(BaseUrl.baseYouUrl)?.searchVid(key
                ?: "")?.enqueue(object : Callback<VidListFOF> {
            override fun onResponse(call: Call<VidListFOF>?, response: Response<VidListFOF>?) {
                Log.e("awefawefawefaweeeeeeeee", response?.body()?.toString())
                callback.onSuccess(response?.body()?.results)
            }

            override fun onFailure(call: Call<VidListFOF>?, t: Throwable?) {
                Log.e("awefawefawefaweeeeeeeee", t.toString())
            }
        })
    }

    override fun callDataWtf(key: String?, callback: Contractor.Model.OnFinishedListener) {
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