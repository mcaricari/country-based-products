package com.itrock.challenge.e_commerce.di

import com.itrock.challenge.e_commerce.data.repositories.PlatziProductsRepository
import com.itrock.challenge.e_commerce.domain.interfaces.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//@Module
//@InstallIn(SingletonComponent::class)
//abstract class RepositoryModule {
//    @Binds
//    abstract fun bindPlatziRepository(impl: PlatziProductsRepository): ProductsRepository
//
//    //@Binds
//    //abstract fun bindFakeRepository(impl: FakeProductsRepository): ProductsRepository
//}