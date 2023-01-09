package com.yusufcancakmak.wallpaperapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.yusufcancakmak.wallpaperapp.paging.RandomPagingSource
import com.yusufcancakmak.wallpaperapp.repository.MainRepository

class RandomViewModel:ViewModel() {
    private val repository=MainRepository()
    val randompage=Pager(config = PagingConfig(pageSize = 30),
    pagingSourceFactory = {
        RandomPagingSource(repository.retroService())
    }).flow.cachedIn(viewModelScope)
}