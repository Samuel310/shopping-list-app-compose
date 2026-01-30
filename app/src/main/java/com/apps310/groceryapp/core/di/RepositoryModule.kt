package com.apps310.groceryapp.core.di

import com.apps310.groceryapp.features.shopping_list.data.repository.ProductRepositoryImpl
import com.apps310.groceryapp.features.shopping_list.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductRepository(
        impl: ProductRepositoryImpl
    ): ProductRepository
}