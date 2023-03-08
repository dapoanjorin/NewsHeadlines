package com.dapo.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dapo.remote.model.Source

@Entity(
    tableName = "articles"
)
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val author: String?,
    val content: String?,
    val description: String?,
    @ColumnInfo(name = "published_at")
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    @ColumnInfo(name = "url_to_image")
    val urlToImage: String?
)