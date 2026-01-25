package com.apps310.groceryapp.features.shopping_list.presentation.view_model.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps310.groceryapp.features.shopping_list.domain.repository.ProductRepository
import com.apps310.groceryapp.features.shopping_list.presentation.view_model.ProductViewModel

class ProductViewModelFactory(
    private val repository: ProductRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}