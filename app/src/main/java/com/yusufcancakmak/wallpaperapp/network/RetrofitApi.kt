package com.yusufcancakmak.wallpaperapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {
    private const val BASE_URL="https://woolapi.herokuapp.com/wallpapers/"


    private val getRetorfitInstance=
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()



        val apiService:RetrofitService = getRetorfitInstance.create(RetrofitService::class.java)
}