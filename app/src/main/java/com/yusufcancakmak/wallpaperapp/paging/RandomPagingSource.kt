package com.yusufcancakmak.wallpaperapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yusufcancakmak.wallpaperapp.models.Data
import com.yusufcancakmak.wallpaperapp.network.RetrofitService

class RandomPagingSource(private val api:RetrofitService):PagingSource<Int,Data> (){
    override fun getRefreshKey(state: PagingState<Int, Data>): Int?{
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
       return try {
           val nextPage=params.key?: FIRST_PAGE_INDEX
           val responseRandom=api.getLatesFromApi(nextPage)
           LoadResult.Page(
               data = responseRandom.data,
                prevKey = null,
                nextKey = responseRandom.paggination?.next?.page

           )
       }catch (e:Exception){
           LoadResult.Error(e)
       }
    }
    companion object{
        private const val FIRST_PAGE_INDEX=1
    }
}