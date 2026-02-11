package com.apps310.groceryapp.features.theme.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apps310.groceryapp.core.ui.theme.GroceryAppTheme
import com.apps310.groceryapp.core.ui.theme.ThemeMode
import com.apps310.groceryapp.features.theme.presentation.ui.components.ThemeOption

@Composable
fun ThemeSettingsScreen(
    currentTheme: ThemeMode,
    onThemeSelected: (ThemeMode) -> Unit
) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = "Theme",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 8.dp)
        )

        Spacer(Modifier.height(8.dp))

        ThemeOption("Light", currentTheme == ThemeMode.LIGHT) {
            onThemeSelected(ThemeMode.LIGHT)
        }

        ThemeOption("Dark", currentTheme == ThemeMode.DARK) {
            onThemeSelected(ThemeMode.DARK)
        }

        ThemeOption("System default", currentTheme == ThemeMode.SYSTEM) {
            onThemeSelected(ThemeMode.SYSTEM)
        }
    }
}

@Preview(name = "ThemeSettingsScreen", showBackground = true)
@Composable
fun PreviewThemeSettingsScreen(){
    GroceryAppTheme{
        ThemeSettingsScreen(
            currentTheme = ThemeMode.LIGHT,
            onThemeSelected = {}
        )
    }
}