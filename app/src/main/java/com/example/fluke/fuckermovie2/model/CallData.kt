package com.example.fluke.fuckermovie2.model

import com.example.fluke.fuckermovie2.Contactor
import com.example.fluke.fuckermovie2.network.WTFManager
import com.example.fluke.fuckermovie2.precenter.MoviePrecenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallData: Contactor.Model{
   // val presenter :Contactor.Precenter = MoviePrecenter()
    override fun callDataWtf(key: String? , view :Contactor.view) {
//        WTFManager.Factory.create()?.search(key ?: "")?.enqueue(object : Callback<MovieList> {
//            override fun onFailure(call: Call<MovieList>?, t: Throwable?) {
//            }
//            override fun onResponse(call: Call<MovieList>?, response: Response<MovieList>?) {
//                if (response != null) {
//                    // TODO callback to view
//                  presenter.recieveData(response.body()?.results,view)
//                }
//            }
//        })
    }
}