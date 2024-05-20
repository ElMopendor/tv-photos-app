package com.luisdev.tvphotosapp

import android.app.Application
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.luisdev.tvphotosapp.data.network.PhotosService
import com.luisdev.tvphotosapp.data.repositories.PhotoRepository
import com.luisdev.tvphotosapp.data.repositories.PhotoRepositoryImpl


import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@HiltAndroidApp
class TvPhotosApp : Application()

@InstallIn(SingletonComponent::class)
@Module
abstract class PhotoRepositoryModule {

    @Binds
    abstract fun bindPhotoRepository(
        movieRepositoryImpl: PhotoRepositoryImpl
    ): PhotoRepository

}



@Module
@InstallIn(SingletonComponent::class)
class NetworkDI {

    private val _baseUrl = BuildConfig.BASE_URL


    @Singleton
    @Provides
    fun provideBaseUrl():String = _baseUrl;

    @Singleton
    @Provides
    fun interpt(): Interceptor {
        return HeaderInterceptor
    }

    @Singleton
    @Provides
    fun provideHttpClient(intercept:Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(intercept)
            .build();
    }

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {
        val networkJson = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .baseUrl(baseUrl)
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(retrofit: Retrofit): PhotosService {
        return retrofit.create(PhotosService::class.java)
    }
}


object HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val _clientID = BuildConfig.CLIENT_ID
        val originalRequest = chain.request()

        val modifiedRequest = originalRequest.newBuilder()
            .header("Authorization", "Client-ID $_clientID")
            .build()

        return chain.proceed(modifiedRequest)
    }
}