package com.apps310.groceryapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.apps310.groceryapp.core.db.AppDatabase
import com.apps310.groceryapp.core.ui.theme.GroceryAppTheme
import com.apps310.groceryapp.features.shopping_list.data.repository.ProductRepositoryImpl
import com.apps310.groceryapp.features.shopping_list.presentation.ui.ShoppingListScreen
import com.apps310.groceryapp.features.shopping_list.presentation.view_model.ProductViewModel
import com.apps310.groceryapp.features.shopping_list.presentation.view_model.factory.ProductViewModelFactory

@Composable
fun App() {
    val context = LocalContext.current

    // Database
    val db = remember {
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "shopping-app-db"
        ).build()
    }

    // Repository
    val repository = remember {
        ProductRepositoryImpl(db.productDao())
    }

    // ViewModel
    val viewModel: ProductViewModel = viewModel(
        factory = ProductViewModelFactory(repository)
    )

    //TODO: use hilt

    GroceryAppTheme{
        ShoppingListScreen(viewModel)
    }
}
