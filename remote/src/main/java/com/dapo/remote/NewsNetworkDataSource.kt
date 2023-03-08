package com.dapo.remote

import com.dapo.remote.util.ApiResponse
import com.dapo.remote.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsNetworkDataSource {

    suspend fun getArticles(): Flow<ApiResponse<List<Article>>>
}