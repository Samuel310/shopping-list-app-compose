package com.apps310.groceryapp.features.shopping_list.presentation.ui.components

import androidx.compose.foundation.border
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.border(width = 1.dp, color = Color.Gray.copy(0.2f), shape = RoundedCornerShape(8.dp))
                .padding(all = 8.dp),
            content = {
                Text("${index + 1}.", color = Color.Gray)
                Spacer(modifier = Modifier.width(16.dp))
                Column (modifier = Modifier.weight(1f)) {
                    Text(product.name, color = Color.Black.copy(0.8f), fontWeight = FontWeight.Bold)
                    Row {
                        Text("Qty", color = Color.Black.copy(0.8f))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("${product.qty}", color = Color.Black.copy(0.8f))
                    }
                }
                IconButton(onClick = onEditBtnClicked) {
                    Icon(
                        imageVector =  Icons.Filled.Edit,
                        contentDescription = "Edit",
                        tint = Color.Black.copy(0.6f),
                    )
                }
                IconButton(onClick = onDeleteBtnClicked) {
                    Icon(
                        imageVector =  Icons.Filled.Delete,
                        contentDescription = "Delete",
                        tint = Color.Black.copy(0.6f),
                    )
                }
            }
        )
    }

}

@Preview(name = "Product List Item")
@Composable
fun PreviewUI(){
    GroceryAppTheme{
        Surface(color = Color.White) {
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
}
