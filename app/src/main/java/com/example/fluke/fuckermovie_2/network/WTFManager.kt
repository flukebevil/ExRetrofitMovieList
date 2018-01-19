package com.example.fluke.fuckermovie_2.network

import retrofit2.Call
import retrofit2.http.GET
import com.example.fluke.fuckermovie_2.model.MovieList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface WTFManager{

    @GET("/3/search/movie?api_key=c1618550083ac39008a92222d9c8a6a9&query=a")
    fun getList():Call<MovieList>

    companion object  Factory {
       fun create(): WTFManager{
           val retrofit = Retrofit.Builder()
                   .addConverterFactory(GsonConverterFactory.create())
                   .baseUrl("http://api.themoviedb.org")
                   .build()
           return retrofit.create(WTFManager::class.java)
       }
   }
}