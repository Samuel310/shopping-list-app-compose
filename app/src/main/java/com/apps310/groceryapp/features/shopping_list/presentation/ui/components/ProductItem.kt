package com.apps310.groceryapp.features.shopping_list.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apps310.groceryapp.core.ui.theme.GroceryAppTheme
import com.apps310.groceryapp.features.shopping_list.domain.model.Product

@Composable
fun ProductItem(index: Int, product: Product, onDeleteBtnClicked : () -> Unit, onEditBtnClicked : () -> Unit){
    Surface(
        shadowElevation = 9.dp,
        shape = RoundedCornerShape(10.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            content = {
                Text("${index + 1}.", color = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(modifier = Modifier.width(16.dp))
                Column (modifier = Modifier.weight(1f)) {
                    Text(product.name, color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold)
                    Row {
                        Text("Qty", color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("${product.qty}", color = MaterialTheme.colorScheme.onSurface)
                    }
                }
                IconButton(onClick = onEditBtnClicked) {
                    Icon(
                        imageVector =  Icons.Filled.Edit,
                        contentDescription = "Edit",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
                IconButton(onClick = onDeleteBtnClicked) {
                    Icon(
                        imageVector =  Icons.Filled.Delete,
                        contentDescription = "Delete",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }
        )
    }

}

@Preview(name = "Product List Item", showBackground = true)
@Composable
fun PreviewUI(){
    GroceryAppTheme{
        Column(modifier = Modifier.padding(16.dp)) {
            ProductItem(
                index = 0,
                product = Product(id = "M", name = "Galaxy S24 Ultra", qty = 2 ),
                onDeleteBtnClicked = {},
                onEditBtnClicked = {},
            )
            Spacer(modifier = Modifier.height(16.dp))
            ProductItem(
                index = 1,
                product = Product(id = "M", name = "Galaxy S25+", qty = 1 ),
                onDeleteBtnClicked = {},
                onEditBtnClicked = {},
            )
        }
    }
}
