package com.dapo.data.repository

import com.dapo.remote.NewsNetworkDataSource
import com.dapo.data.mapper.NewsDataModelMapper
import com.dapo.data.util.ConnectivityManagerNetworkMonitor
import com.dapo.remote.util.ApiResponse
import com.dapo.data.util.NetworkBoundResource
import com.dapo.data.util.NetworkMonitor
import com.dapo.remote.util.Resource
import com.dapo.database.dao.ArticleDao
import com.dapo.remote.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val articleDao: ArticleDao,
    private val mapper: NewsDataModelMapper,
    private val network: NewsNetworkDataSource,
    private val networkMonitor: ConnectivityManagerNetworkMonitor
) : NewsRepository {

    override fun getArticles(): Flow<Resource<List<Article>>> =

        object : NetworkBoundResource<List<Article>, List<Article>>() {
            override fun loadFromDB(): Flow<List<Article>> {
                return articleDao.getArticlesStream().map {
                    mapper.mapFromEntityList(it)
                }
            }

            override fun shouldFetch(data: List<Article>?): Boolean {
               return networkMonitor.isCurrentlyConnected()
            }


            override suspend fun createCall(): Flow<ApiResponse<List<Article>>> {
                return  network.getArticles()
            }

            override suspend fun saveCallResult(data: List<Article>) {
                articleDao.insertArticles(mapper.mapFromModelList(data))
            }
        }.asFlow()
}