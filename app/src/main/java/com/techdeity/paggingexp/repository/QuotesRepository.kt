package com.techdeity.paggingexp.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.techdeity.paggingexp.paging.QuotePagingSource
import com.techdeity.paggingexp.retrofit.QuotesApi
import javax.inject.Inject

class QuotesRepository @Inject constructor(val quotesApi: QuotesApi) {
    fun getQuotes()= Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = {QuotePagingSource(quotesApi)}
    ).liveData
}