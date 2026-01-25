package com.apps310.groceryapp.features.shopping_list.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps310.groceryapp.features.shopping_list.domain.model.Product
import com.apps310.groceryapp.features.shopping_list.domain.repository.ProductRepository
import com.apps310.groceryapp.features.shopping_list.presentation.state.ProductVMState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import java.util.UUID


class ProductViewModel(private val repository: ProductRepository) : ViewModel(){

    private val _state = MutableStateFlow(ProductVMState())
    val state: StateFlow<ProductVMState> = _state

    init {
        observeProducts()
    }

    private fun observeProducts() {
        viewModelScope.launch {
            repository.getProducts()
                .onStart { setLoading(true) }
                .collect { products ->
                _state.value = _state.value.copy(
                    products = products,
                    isLoading = false,
                )
            }
        }
    }

    fun addProduct(id: String?, name: String, qty: Int) {
        viewModelScope.launch {
            setLoading(true)
            try {
                repository.insertProduct(
                    Product(
                        id = id ?: UUID.randomUUID().toString(),
                        name = name,
                        qty = qty
                    )
                )
            } catch (e: Exception) {
                //TODO: implement logger
            } finally {
                setLoading(false)
            }
        }
    }

    @Deprecated("Do not pass Product directly")
    fun addProduct(product : Product){
        viewModelScope.launch {
            setLoading(true)
            try {
                repository.insertProduct(product)
            } catch (e: Exception) {
                //TODO: implement logger
            } finally {
                setLoading(false)
            }
        }
    }

    fun removeProduct(product: Product){
        viewModelScope.launch {
            setLoading(true)
            try {
                repository.deleteProduct(product)
            } catch (e: Exception) {
                //TODO: implement logger
            } finally {
                setLoading(false)
            }
        }
    }

    fun updateProduct(updatedProduct: Product) {
        viewModelScope.launch {
            setLoading(true)
            try {
                repository.updateProduct(updatedProduct)
            } catch (e: Exception) {
                //TODO: implement logger
            } finally {
                setLoading(false)
            }
        }
    }

    fun toggleDialog(product: Product?, openDialog: Boolean){
        _state.value = _state.value.copy(selectedProduct = product, showDialog = openDialog);
    }

    private fun setLoading(value: Boolean) {
        _state.value = _state.value.copy(isLoading = value)
    }

}