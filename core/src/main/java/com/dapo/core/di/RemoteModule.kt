package com.dapo.core.di

import com.dapo.remote.NewsNetworkDataSource
import com.dapo.remote.retrofit.RetrofitNewsNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @[Provides Singleton]
    fun providesRetrofitNetwork(): NewsNetworkDataSource {
        return RetrofitNewsNetwork()
    }

}