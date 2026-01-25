package com.apps310.groceryapp.features.shopping_list.data.mapper

import com.apps310.groceryapp.features.shopping_list.data.local.entity.ProductEntity
import com.apps310.groceryapp.features.shopping_list.domain.model.Product

fun ProductEntity.toDomain(): Product {
    return Product(
        id = id,
        name = name,
        qty = qty
    )
}

fun Product.toEntity(): ProductEntity {
    return ProductEntity(
        id = id,
        name = name,
        qty = qty
    )
}