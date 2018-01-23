package com.example.fluke.fuckermovie2.network

import android.util.Log
import retrofit2.Call
import retrofit2.http.GET
import com.example.fluke.fuckermovie2.model.MovieList
import com.example.fluke.fuckermovie2.model.VidListFOF
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

class WTFManager {

    companion object Factory {
        var serviceWTF: BaseService? = null
        fun create(baseurl: String): BaseService? {
            serviceWTF = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseurl)
                    .build().create(BaseService::class.java)
            return serviceWTF as BaseService?
        }
    }
}