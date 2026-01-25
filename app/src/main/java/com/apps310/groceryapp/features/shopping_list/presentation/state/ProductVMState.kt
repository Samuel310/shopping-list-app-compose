package com.apps310.groceryapp.features.shopping_list.presentation.state

import com.apps310.groceryapp.features.shopping_list.data.Product

data class ProductVMState(
    val products: List<Product> = emptyList(),
    val selectedProduct: Product? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val showDialog : Boolean = false,
)