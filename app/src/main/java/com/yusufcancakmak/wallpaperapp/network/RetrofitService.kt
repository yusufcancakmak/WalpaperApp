package com.yusufcancakmak.wallpaperapp.network

import com.yusufcancakmak.wallpaperapp.models.Wallpaper
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("Random")
    suspend fun getHomeFromApi(@Query("page")page:Int?):Wallpaper

    @GET("Popular")
    suspend fun getPopularFromApi(@Query("page")page:Int?):Wallpaper

    @GET("latest")
    suspend fun getLatesFromApi(@Query("page")page:Int?):Wallpaper

    @GET("category")
    suspend fun getCategoryFromApi(@Query("page")page:Int?,@Query("category")category:String):Wallpaper
}