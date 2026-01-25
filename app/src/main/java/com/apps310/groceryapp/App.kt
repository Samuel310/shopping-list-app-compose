package com.apps310.groceryapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.apps310.groceryapp.core.ui.theme.GroceryAppTheme
import com.apps310.groceryapp.features.shopping_list.presentation.components.ProductDialog
import com.apps310.groceryapp.features.shopping_list.presentation.components.ProductItem
import com.apps310.groceryapp.features.shopping_list.presentation.view_model.ProductViewModel

@Composable
fun App(productViewModel: ProductViewModel) {

    val state by productViewModel.state.collectAsState()

    if(state.showDialog){
        ProductDialog(oldProduct = state.selectedProduct) { product ->
            if(state.selectedProduct != null && product != null){
                productViewModel.updateProduct(product);
            }else if(product != null){
                productViewModel.addProduct(product);
            }
            productViewModel.toggleDialog(product = null, openDialog = false);
        }
    }

    GroceryAppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                @OptIn(ExperimentalMaterial3Api::class)
                CenterAlignedTopAppBar(
                    title = {
                        Text("Shopping List")
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        productViewModel.toggleDialog(product = null, openDialog = true);
                    },
                    content = {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Add Product"
                        )
                    }
                )
            },
            content = { innerPadding ->
                LazyColumn(
                    modifier = Modifier.padding(innerPadding)
                ) {
                    itemsIndexed(state.products) { index, product ->
                        ProductItem(
                            product = product,
                            index = index,
                            onEditBtnClicked = {
                                productViewModel.toggleDialog(product = product, openDialog = true);
                            },
                            onDeleteBtnClicked = {
                                productViewModel.removeProduct(product);
                            },
                        )
                    }
                }
            }
        )
    }
}
