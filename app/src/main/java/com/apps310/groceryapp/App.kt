package com.apps310.groceryapp

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.apps310.groceryapp.core.ui.theme.GroceryAppTheme
import com.apps310.groceryapp.features.shopping_list.presentation.ui.ShoppingListScreen
import com.apps310.groceryapp.features.shopping_list.presentation.view_model.ProductViewModel

@Composable
fun App() {
    GroceryAppTheme{
        ShoppingListScreen(hiltViewModel<ProductViewModel>())
    }
}
