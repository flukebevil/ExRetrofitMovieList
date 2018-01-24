package com.example.fluke.fuckermovie2.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WTFManager {

    companion object Factory {
        var serviceWTF: BaseService? = null
        fun create(baseUrl: String): BaseService? {
            serviceWTF = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseUrl)
                    .build().create(BaseService::class.java)
            return serviceWTF as BaseService?
        }
    }
}