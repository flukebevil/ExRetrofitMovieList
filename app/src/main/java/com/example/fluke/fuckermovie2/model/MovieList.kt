package com.example.fluke.fuckermovie2.model

import com.google.gson.annotations.SerializedName
import org.parceler.Parcel

@Parcel
data class MovieList(@SerializedName("results")var results :ArrayList<Movie>?=null)
