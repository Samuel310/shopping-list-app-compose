package com.apps310.groceryapp.features.shopping_list.presentation.view_model

import androidx.lifecycle.ViewModel
import com.apps310.groceryapp.features.shopping_list.domain.model.Product
import com.apps310.groceryapp.features.shopping_list.presentation.state.ProductDialogVMState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class ProductDialogViewModel(product: Product?) : ViewModel(){
    private val _state = MutableStateFlow(ProductDialogVMState())
    val state: StateFlow<ProductDialogVMState> = _state

    init{
        if(product != null){
            _state.value = _state.value.copy(
                name = product.name,
                qty = product.qty.toString(),
            )
        }
    }

    fun onNameChanged(value : String){
        var errorMsg : String? = null
        if(value.isEmpty()){
            errorMsg = "Name cannot be empty"
        }
        _state.value = _state.value.copy(
            name = value,
            nameErrorMsg = errorMsg
        )
    }

    fun onQtyChanged(value : String){
        var errorMsg : String? = null
        if(value.isEmpty()){
            errorMsg = "Quantity cannot be empty"
        }
        val parsedQty = value.toIntOrNull()
        if(parsedQty == null){
            errorMsg = "Enter a valid quantity."
        }
        _state.value = _state.value.copy(
            qty = value,
            qtyErrorMsg = errorMsg
        )
    }
}

