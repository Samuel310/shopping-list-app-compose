package com.apps310.groceryapp.features.theme.data.local

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.themeDataStore by preferencesDataStore(name = "theme_prefs")

object ThemePreferences {
    val THEME_MODE = stringPreferencesKey("theme_mode")
}