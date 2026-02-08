package com.apps310.groceryapp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.apps310.groceryapp.core.ui.theme.GroceryAppTheme
import com.apps310.groceryapp.core.ui.theme.ThemeMode
import com.apps310.groceryapp.features.shopping_list.presentation.ui.ShoppingListScreen
import com.apps310.groceryapp.features.shopping_list.presentation.view_model.ProductViewModel
import com.apps310.groceryapp.features.theme.presentation.view_model.ThemeViewModel
import androidx.compose.runtime.getValue

@Composable
fun App(themeViewModel: ThemeViewModel) {
    val state by themeViewModel.state.collectAsState()

    val darkTheme = when (state.theme) {
        ThemeMode.LIGHT -> false
        ThemeMode.DARK -> true
        ThemeMode.SYSTEM -> isSystemInDarkTheme()
    }

    GroceryAppTheme(darkTheme = darkTheme){
        ShoppingListScreen(hiltViewModel<ProductViewModel>())
    }
}
