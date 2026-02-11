package com.apps310.groceryapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.apps310.groceryapp.features.base.presentation.ui.BaseScreen
import com.apps310.groceryapp.features.settings.presentation.ui.SettingsScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.BaseScreen.route) {
        composable(Screen.BaseScreen.route) {
            BaseScreen(
                navigateToSettingsScreen = {
                    navController.navigate(Screen.SettingsScreen.route)
                }
            )
        }
        composable(Screen.SettingsScreen.route) {
            SettingsScreen(
                navigateToBaseScreen = {
                    navController.popBackStack()
                }
            )
        }
    }
}