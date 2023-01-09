package com.yusufcancakmak.wallpaperapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.yusufcancakmak.wallpaperapp.paging.HomePagingSource
import com.yusufcancakmak.wallpaperapp.repository.MainRepository

class HomeViewModel:ViewModel() {
   private val repository=MainRepository()
    val homePage=Pager(config = PagingConfig(pageSize = 30),
    pagingSourceFactory = {
        HomePagingSource(repository.retroService())
    }).flow.cachedIn(viewModelScope)
}