package com.techdeity.paggingexp.di

import com.techdeity.paggingexp.retrofit.QuotesApi
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule{

    fun getRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("BASE_URL").addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun quotesApi(retrofit: Retrofit):QuotesApi{
        return retrofit.create(QuotesApi::class.java)
    }

}