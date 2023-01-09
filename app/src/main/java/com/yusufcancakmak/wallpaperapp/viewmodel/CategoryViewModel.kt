package com.yusufcancakmak.wallpaperapp.viewmodel

import androidx.lifecycle.ViewModel
import com.yusufcancakmak.wallpaperapp.repository.MainRepository

class CategoryViewModel:ViewModel() {

    val repository=MainRepository()
}