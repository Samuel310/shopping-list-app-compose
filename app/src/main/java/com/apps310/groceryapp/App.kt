package com.apps310.groceryapp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.apps310.groceryapp.core.ui.theme.GroceryAppTheme
import com.apps310.groceryapp.core.ui.theme.ThemeMode
import com.apps310.groceryapp.features.theme.presentation.view_model.ThemeViewModel
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.apps310.groceryapp.core.navigation.AppNavGraph

@Composable
fun App(themeViewModel: ThemeViewModel) {
    val state by themeViewModel.state.collectAsState()

    val darkTheme = when (state.theme) {
        ThemeMode.LIGHT -> false
        ThemeMode.DARK -> true
        ThemeMode.SYSTEM -> isSystemInDarkTheme()
    }

    val navController = rememberNavController()

    GroceryAppTheme(darkTheme = darkTheme){
        AppNavGraph(navController)
    }
}
