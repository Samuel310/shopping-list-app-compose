package com.apps310.groceryapp.features.shopping_list.domain.repository

import com.apps310.groceryapp.features.shopping_list.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun getProducts(): Flow<List<Product>>

    suspend fun insertProduct(product: Product)

    suspend fun updateProduct(product: Product)

    suspend fun deleteProduct(product: Product)
}