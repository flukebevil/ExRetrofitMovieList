package com.example.fluke.fuckermovie2.network

import com.example.fluke.fuckermovie2.model.MovieList
import com.example.fluke.fuckermovie2.model.VidListFOF
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface BaseService {
    @GET("/3/search/movie?api_key=c1618550083ac39008a92222d9c8a6a9")
    fun search(@Query("query") query: String): Call<MovieList>

    @GET("search?part=snippet&type=video&key=AIzaSyBLvU2V_-8LyrNTma4Hx4fOHN59pV0-N3A")
    fun searchVid(@Query("q") query: String): Call<VidListFOF>
}