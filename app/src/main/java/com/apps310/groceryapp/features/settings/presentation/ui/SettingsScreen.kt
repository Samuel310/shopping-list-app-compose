package com.apps310.groceryapp.features.settings.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.apps310.groceryapp.features.theme.presentation.ui.ThemeSettingsScreen
import com.apps310.groceryapp.features.theme.presentation.view_model.ThemeViewModel

@Composable
fun SettingsScreen(navigateToBaseScreen: () -> Unit, themeViewModel: ThemeViewModel = hiltViewModel<ThemeViewModel>()){
    val state by themeViewModel.state.collectAsState()
    Scaffold(
        topBar = {
            @OptIn(ExperimentalMaterial3Api::class)
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = navigateToBaseScreen) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back Btn",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                },
                title = {
                    Text("Settings")
                },
            )
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxWidth().fillMaxHeight()) {
            ThemeSettingsScreen(currentTheme = state.theme) {
                themeViewModel.setTheme(it)
            }
        }
    }
}