package com.dapo.core.di

import android.app.Application
import com.dapo.remote.NewsNetworkDataSource
import com.dapo.data.mapper.NewsDataModelMapper
import com.dapo.data.repository.NewsRepository
import com.dapo.data.repository.NewsRepositoryImpl
import com.dapo.data.util.ConnectivityManagerNetworkMonitor
import com.dapo.data.util.NetworkMonitor
import com.dapo.database.dao.ArticleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @[Provides Singleton]
    fun providesNewsRepository(
        articleDao: ArticleDao,
        mapper: NewsDataModelMapper,
        networkDataSource: NewsNetworkDataSource,
        networkMonitor: ConnectivityManagerNetworkMonitor
    ): NewsRepository {
        return NewsRepositoryImpl(articleDao, mapper, networkDataSource, networkMonitor)
    }

    @Provides
    fun providesNewsMapper(): NewsDataModelMapper {
        return NewsDataModelMapper()
    }

    @[Provides Singleton]
    fun providesConnectivityMonitor(application: Application) =
        ConnectivityManagerNetworkMonitor(application)
}