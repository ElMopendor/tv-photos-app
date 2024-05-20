package com.luisdev.tvphotosapp.data.network

import com.luisdev.tvphotosapp.data.models.PhotosResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface PhotosService {
    @GET("/photos/random")
    suspend fun getPhotoList(
        @Query("query") query: String,
        @Query("count") count: Int
    ): Response<List<PhotosResponse>>
}