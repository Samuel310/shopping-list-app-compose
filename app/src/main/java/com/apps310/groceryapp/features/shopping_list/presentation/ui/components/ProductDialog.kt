package com.apps310.groceryapp.features.shopping_list.presentation.ui.components

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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.apps310.groceryapp.core.ui.theme.GroceryAppTheme
import com.apps310.groceryapp.features.shopping_list.domain.model.Product
import com.apps310.groceryapp.features.shopping_list.presentation.view_model.ProductDialogViewModel
import java.util.UUID

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
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            var cardTitle = "Add Product"
            if(oldProduct != null){
                cardTitle = " Update Product"
            }

            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(cardTitle, style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(12.dp))
                TextField(
                    value = state.name,
                    onValueChange = { value ->
                        productDialogViewModel.onNameChanged(value)
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
                        productDialogViewModel.onQtyChanged(value)
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
                Button(
                    shape = RoundedCornerShape(8.dp),
                    onClick = {
                        val qty = state.qty.toIntOrNull()
                        if(state.qtyErrorMsg == null && state.nameErrorMsg == null && qty != null){
                            val id = oldProduct?.id ?: UUID.randomUUID().toString()
                            val newProduct = Product(
                                id = id,
                                name = state.name,
                                qty = qty,
                            )
                            onDismiss(newProduct)
                        }
                    }
                ) {
                    Text("Add")
                }
            }
        }
    }
}

@Preview(name = "Product Alert Dialog")
@Composable
fun PreviewProductDialog(){
    GroceryAppTheme{
        Surface(color = Color.White) {
            Column(modifier = Modifier.padding(16.dp)) {
                ProductDialog(oldProduct = Product(id = "M", name = "Galaxy S24 Ultra", qty = 2 )) { }
            }
        }
    }
}

