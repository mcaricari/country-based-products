package com.itrock.challenge.e_commerce.di

import com.itrock.challenge.e_commerce.data.api.FakeApi
import com.itrock.challenge.e_commerce.data.api.PlatziApi
import com.itrock.challenge.e_commerce.data.repositories.PlatziProductsRepository
import com.itrock.challenge.e_commerce.domain.interfaces.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    private const val PLATZI_API = "https://api.escuelajs.co/api/v1/"
    private const val FAKE_API = "https://fakestoreapi.com/"

    @Provides
    @Singleton
    @Named("platzi")
    fun providePlatziApiRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(PLATZI_API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    @Named("fake")
    fun provideFakeApiRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(FAKE_API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun providePlatziApi(@Named("platzi") retrofit: Retrofit): PlatziApi = retrofit.create(PlatziApi::class.java)

    @Provides
    fun provideFakeApi(@Named("fake") retrofit: Retrofit): FakeApi = retrofit.create(FakeApi::class.java)
}