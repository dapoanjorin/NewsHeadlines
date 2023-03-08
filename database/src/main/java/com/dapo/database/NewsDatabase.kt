package com.dapo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dapo.database.dao.ArticleDao
import com.dapo.database.model.ArticleEntity
import com.dapo.database.util.SourceConverter


@Database(
    entities = [ArticleEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    SourceConverter::class
)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}