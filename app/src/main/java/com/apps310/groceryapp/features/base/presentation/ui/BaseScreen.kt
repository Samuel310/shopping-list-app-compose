package com.apps310.groceryapp.features.base.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.apps310.groceryapp.features.shopping_list.presentation.ui.ShoppingListScreen
import com.apps310.groceryapp.features.shopping_list.presentation.view_model.ProductViewModel

@Composable
fun BaseScreen(navigateToSettingsScreen: () -> Unit, productListViewModel: ProductViewModel = hiltViewModel<ProductViewModel>()){
    Scaffold(
        topBar = {
            @OptIn(ExperimentalMaterial3Api::class)
            CenterAlignedTopAppBar(
                title = {
                    Text("Shopping List")
                },
                actions = {
                    IconButton(onClick = navigateToSettingsScreen) {
                        Icon(
                            imageVector =  Icons.Filled.Settings,
                            contentDescription = "Settings",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                }
            )
        },
    ) {innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            ShoppingListScreen(productListViewModel)
        }
    }
}