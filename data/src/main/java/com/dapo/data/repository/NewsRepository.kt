package com.dapo.data.repository

import com.dapo.remote.util.Resource
import com.dapo.database.model.ArticleEntity
import com.dapo.remote.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getArticles(): Flow<Resource<List<Article>>>
}