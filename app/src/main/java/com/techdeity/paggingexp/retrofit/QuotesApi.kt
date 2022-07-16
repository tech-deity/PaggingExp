package com.techdeity.paggingexp.retrofit

import com.techdeity.paggingexp.model.QuoteList
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page")page:Int):QuoteList

}