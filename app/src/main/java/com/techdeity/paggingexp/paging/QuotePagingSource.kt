package com.techdeity.paggingexp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.techdeity.paggingexp.model.Result
import com.techdeity.paggingexp.retrofit.QuotesApi

class QuotePagingSource(val quotesApi: QuotesApi) : PagingSource<Int, Result>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {

        return try{
            val position =params.key?: 1
            val response = quotesApi.getQuotes(position)
            LoadResult.Page(
                data = response.results,
                prevKey = if(position==1)null else position-1,
                nextKey = if(position==response.totalPages)null else position+1

            )

        }catch (e:Exception){

            LoadResult.Error(e)

        }

    }
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {

        return state.anchorPosition?.let{
            //if first
            state.closestPageToPosition(it)?.prevKey?.plus(1) ?:
           //if last
            state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }


}