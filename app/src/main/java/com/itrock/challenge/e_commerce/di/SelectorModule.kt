package com.itrock.challenge.e_commerce.di

import com.itrock.challenge.e_commerce.data.repositories.ProductsRepositorySelector
import com.itrock.challenge.e_commerce.domain.interfaces.SourceSelector
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SelectorModule {
    @Binds
    @Singleton
    abstract fun bindSourceSelector(impl: ProductsRepositorySelector): SourceSelector
}