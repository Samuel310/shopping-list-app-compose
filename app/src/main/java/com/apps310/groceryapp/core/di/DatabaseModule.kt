package com.apps310.groceryapp.core.di

import android.content.Context
import androidx.room.Room
import com.apps310.groceryapp.core.db.AppDatabase
import com.apps310.groceryapp.features.shopping_list.data.local.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDB(
        @ApplicationContext context: Context
    ) : AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "shopping-app-db"
        ).build()
    }

    @Provides
    fun provideProductDao(
        db: AppDatabase
    ): ProductDao = db.productDao()

}