package com.apps310.groceryapp.features.shopping_list.data.repository

import com.apps310.groceryapp.features.shopping_list.data.local.dao.ProductDao
import com.apps310.groceryapp.features.shopping_list.data.mapper.toDomain
import com.apps310.groceryapp.features.shopping_list.data.mapper.toEntity
import com.apps310.groceryapp.features.shopping_list.domain.model.Product
import com.apps310.groceryapp.features.shopping_list.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductRepositoryImpl(private val dao: ProductDao) : ProductRepository {

    override fun getProducts(): Flow<List<Product>> {
        return dao.getProducts().map { entities ->
                entities.map { it.toDomain() }
            }
    }

    override suspend fun insertProduct(product: Product) {
        dao.insertProduct(product.toEntity())
    }

    override suspend fun updateProduct(product: Product) {
        dao.updateProduct(product.toEntity())
    }

    override suspend fun deleteProduct(product: Product) {
        dao.deleteProduct(product.toEntity())
    }

}