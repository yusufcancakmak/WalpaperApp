package com.yusufcancakmak.wallpaperapp.repository

import com.yusufcancakmak.wallpaperapp.network.RetrofitApi
import com.yusufcancakmak.wallpaperapp.network.RetrofitService

class MainRepository {

    fun retroService():RetrofitService = RetrofitApi.apiService
}