package com.apps310.groceryapp.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.apps310.groceryapp.features.shopping_list.data.local.dao.ProductDao
import com.apps310.groceryapp.features.shopping_list.data.local.entity.ProductEntity

@Database(
    entities = [ProductEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}