package com.yusufcancakmak.wallpaperapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.yusufcancakmak.wallpaperapp.paging.PopularPagingSource
import com.yusufcancakmak.wallpaperapp.repository.MainRepository

class PopularViewModel:ViewModel() {

    private val repository=MainRepository()
    val popularpage= Pager(config = PagingConfig(pageSize = 30),
        pagingSourceFactory = {
            PopularPagingSource(repository.retroService())
        }).flow.cachedIn(viewModelScope)
}