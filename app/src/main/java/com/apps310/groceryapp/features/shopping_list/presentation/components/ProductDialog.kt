package com.apps310.groceryapp.features.shopping_list.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.apps310.groceryapp.features.shopping_list.data.Product
import com.apps310.groceryapp.features.shopping_list.presentation.view_model.ProductDialogViewModel
import kotlin.random.Random

@Composable
fun ProductDialog(
    oldProduct: Product?,
    onDismiss: (product : Product?) -> Unit,
) {
    val productDialogViewModel = remember(oldProduct) {
        ProductDialogViewModel(oldProduct)
    }

    val state by productDialogViewModel.state.collectAsState()

    Dialog(onDismissRequest = { onDismiss(null) }) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Add Product", style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(12.dp))
                TextField(
                    value = state.name,
                    onValueChange = { value ->
                        productDialogViewModel.onNameChanged(value);
                    },
                    isError = state.nameErrorMsg != null,
                    label = {
                        Text("Name")
                    },
                    placeholder = {
                        Text("Place Holder")
                    },
                    supportingText = {
                        if(state.nameErrorMsg != null){
                            Text(state.nameErrorMsg!!, color = MaterialTheme.colorScheme.error)
                        }
                    },
                    trailingIcon = {
                        if (state.nameErrorMsg != null) {
                            Icon(
                                imageVector = Icons.Filled.Info,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                )
                TextField(
                    value = state.qty,
                    onValueChange = { value ->
                        productDialogViewModel.onQtyChanged(value);
                    },
                    isError = state.qtyErrorMsg != null,
                    label = {
                        Text("Qty")
                    },
                    supportingText = {
                        if(state.qtyErrorMsg != null){
                            Text(state.qtyErrorMsg!!, color = MaterialTheme.colorScheme.error)
                        }
                    },
                    trailingIcon = {
                        if (state.qtyErrorMsg != null) {
                            Icon(
                                imageVector = Icons.Filled.Info,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                )
                Spacer(Modifier.height(16.dp))
                Button(onClick = {
                    val qty = state.qty.toIntOrNull()
                    if(state.qtyErrorMsg == null && state.nameErrorMsg == null && qty != null){
                        var id = oldProduct?.id ?: Random.nextInt(Int.MAX_VALUE)
                        val newProduct = Product(
                            id = id,
                            name = state.name,
                            qty = qty,
                        );
                        onDismiss(newProduct);
                    }
                }) {
                    Text("Add")
                }
            }
        }
    }
}
