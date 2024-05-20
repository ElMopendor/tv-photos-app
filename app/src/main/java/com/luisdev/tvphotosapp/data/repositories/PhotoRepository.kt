package com.luisdev.tvphotosapp.data.repositories

import com.luisdev.tvphotosapp.data.entities.PhotoList
import com.luisdev.tvphotosapp.data.network.api.NetworkResult


interface PhotoRepository{
    suspend fun getPhotos(query:String = "", pagination:Int = 0) : NetworkResult<PhotoList>
}