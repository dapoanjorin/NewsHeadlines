package com.dapo.remote.retrofit

import com.dapo.remote.BuildConfig
import com.dapo.remote.NewsNetworkDataSource
import com.dapo.remote.util.ApiResponse
import com.dapo.remote.model.Article
import com.dapo.remote.model.NewsRemoteResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton


interface NewsApi {

    @GET("/v2/top-headlines?country=us")
    suspend fun getNewArticles() : NewsRemoteResponse

}

private const val NewsBaseUrl = BuildConfig.BACKEND_URL

@Singleton
class RetrofitNewsNetwork @Inject constructor(
) : NewsNetworkDataSource {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val networkApi = Retrofit.Builder()
        .baseUrl(NewsBaseUrl)
        .client(
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                )
                .addInterceptor { chain: Interceptor.Chain ->
                    chain.proceed(
                        chain.request()
                            .newBuilder()
                            .url(chain.request().url.newBuilder().addQueryParameter("apiKey", BuildConfig.API_KEY).build())
                            .build()
                    )
                }
                .build()
        )
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(NewsApi::class.java)




    override suspend fun getArticles(): Flow<ApiResponse<List<Article>>> = channelFlow {
        try {
            val response = networkApi.getNewArticles()
            send(ApiResponse.Success(response.articles))
        } catch(e: Exception) {
            send(ApiResponse.Error(e.toString()))
        }
    }

}
