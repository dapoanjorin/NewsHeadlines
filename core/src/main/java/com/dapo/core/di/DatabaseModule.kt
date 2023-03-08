package com.dapo.core.di

import android.content.Context
import androidx.room.Room
import com.dapo.database.NewsDatabase
import com.dapo.database.dao.ArticleDao
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
    fun providesNiaDatabase(
        @ApplicationContext context: Context,
    ): NewsDatabase = Room.databaseBuilder(
        context,
        NewsDatabase::class.java,
        "news-database"
    )
        .fallbackToDestructiveMigration()
        . build()

    @Provides
    fun providesAuthorDao(
        database: NewsDatabase,
    ): ArticleDao = database.articleDao()
}
