package com.apps310.groceryapp.features.settings.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.apps310.groceryapp.features.theme.presentation.ui.ThemeSettingsScreen
import com.apps310.groceryapp.features.theme.presentation.view_model.ThemeViewModel

@Composable
fun SettingsScreen(themeViewModel: ThemeViewModel){
    val state by themeViewModel.state.collectAsState()
    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxWidth().fillMaxHeight()) {
            ThemeSettingsScreen(currentTheme = state.theme) {
                themeViewModel.setTheme(it)
            }
        }
    }
}