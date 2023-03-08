package com.dapo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dapo.database.model.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Query(value = "SELECT * FROM articles")
    fun getArticlesStream(): Flow<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertArticles(entities: List<ArticleEntity>)

}