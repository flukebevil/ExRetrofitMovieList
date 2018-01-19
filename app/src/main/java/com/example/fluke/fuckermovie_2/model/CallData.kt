package com.example.fluke.fuckermovie_2.model

import com.example.fluke.fuckermovie_2.Contactor
import com.example.fluke.fuckermovie_2.network.WTFManager
import com.example.fluke.fuckermovie_2.precenter.MoviePrecenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallData:Contactor.Model{
    val precenter : Contactor.Precenter = MoviePrecenter()

    override fun dataCallBack(){
        WTFManager.Factory.create().getList().enqueue(object : Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>?, t: Throwable?) {
                }
                override fun onResponse(call: Call<MovieList>?, response: Response<MovieList>?) {
                    if (response != null) {
                        precenter.reciever(response.body()!!.results)
                    }
                }
            })
    }

}