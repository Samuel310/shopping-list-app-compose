package com.apps310.groceryapp.features.theme.presentation.view_model

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps310.groceryapp.core.ui.theme.ThemeMode
import com.apps310.groceryapp.features.theme.data.local.ThemePreferences
import com.apps310.groceryapp.features.theme.presentation.state.ThemeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : ViewModel() {

    private val _state = MutableStateFlow(ThemeState())
    val state: StateFlow<ThemeState> = _state.asStateFlow()

    init {
        observeTheme()
    }

    private fun observeTheme() {
        viewModelScope.launch {
            dataStore.data.collect { prefs ->
                val themeMode = when (prefs[ThemePreferences.THEME_MODE]) {
                    ThemeMode.LIGHT.name -> ThemeMode.LIGHT
                    ThemeMode.DARK.name -> ThemeMode.DARK
                    else -> ThemeMode.SYSTEM
                }
                _state.value = ThemeState(theme = themeMode)
            }
        }
    }

    fun setTheme(themeMode: ThemeMode) {
        viewModelScope.launch {
            dataStore.edit { prefs ->
                prefs[ThemePreferences.THEME_MODE] = themeMode.name
            }
        }
    }
}
