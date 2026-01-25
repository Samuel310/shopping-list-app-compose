package com.apps310.groceryapp.features.shopping_list.presentation.state

data class ProductDialogVMState(
    val name : String = "",
    val qty : String = "",
    val nameErrorMsg: String? = null,
    val qtyErrorMsg : String? = null,
)
