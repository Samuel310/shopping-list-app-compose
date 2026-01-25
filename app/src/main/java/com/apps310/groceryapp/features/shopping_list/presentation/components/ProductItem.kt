package com.apps310.groceryapp.features.shopping_list.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.apps310.groceryapp.features.shopping_list.domain.model.Product

@Composable
fun ProductItem(index: Int, product: Product, onDeleteBtnClicked : () -> Unit, onEditBtnClicked : () -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
        content = {
            Text("${index + 1}")
            Spacer(modifier = Modifier.width(16.dp))
            Column (modifier = Modifier.weight(1f)) {
                Text(product.name)
                Row {
                    Text("Qty")
                    Spacer(modifier = Modifier.width(16.dp))
                    Text("${product.qty}")
                }
            }
            IconButton(onClick = onEditBtnClicked) {
                Icon(
                    imageVector =  Icons.Filled.Edit,
                    contentDescription = "Edit"
                )
            }
            IconButton(onClick = onDeleteBtnClicked) {
                Icon(
                    imageVector =  Icons.Filled.Delete,
                    contentDescription = "Delete"
                )
            }
        }
    )
}
