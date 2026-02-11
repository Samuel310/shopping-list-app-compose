package com.apps310.groceryapp.core.navigation

sealed class Screen(val route: String) {
    object BaseScreen : Screen("base_screen")
    object SettingsScreen : Screen("settings_screen")
}