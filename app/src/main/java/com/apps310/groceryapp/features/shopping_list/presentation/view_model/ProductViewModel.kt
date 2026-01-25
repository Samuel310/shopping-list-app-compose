package com.apps310.groceryapp.features.shopping_list.presentation.view_model

import androidx.lifecycle.ViewModel
import com.apps310.groceryapp.features.shopping_list.data.Product
import com.apps310.groceryapp.features.shopping_list.presentation.state.ProductVMState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class ProductViewModel : ViewModel(){

    private val _state = MutableStateFlow(ProductVMState())
    val state: StateFlow<ProductVMState> = _state

    fun addProduct(product : Product){
        _state.value = _state.value.copy(products = _state.value.products + product)
    }

    fun removeProduct(product: Product){
        _state.value = _state.value.copy(products = _state.value.products - product)
    }

    fun updateProduct(updatedProduct: Product) {
        _state.value = _state.value.copy(
            products = _state.value.products.map { product ->
                if (product.id == updatedProduct.id) updatedProduct else product
            }
        )
    }

    fun toggleDialog(product: Product?, openDialog: Boolean){
        _state.value = _state.value.copy(selectedProduct = product, showDialog = openDialog);
    }

}