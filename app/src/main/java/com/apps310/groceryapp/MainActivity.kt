package com.apps310.groceryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.platform.LocalContext
import androidx.room.Room
import com.apps310.groceryapp.core.db.AppDatabase
import com.apps310.groceryapp.features.shopping_list.data.repository.ProductRepositoryImpl
import com.apps310.groceryapp.features.shopping_list.presentation.view_model.ProductViewModel
import com.apps310.groceryapp.features.shopping_list.presentation.view_model.factory.ProductViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

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

            App(viewModel)
        }
    }
}











