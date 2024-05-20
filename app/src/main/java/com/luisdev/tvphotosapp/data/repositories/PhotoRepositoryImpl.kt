package com.luisdev.tvphotosapp.data.repositories

import com.luisdev.tvphotosapp.data.entities.PhotoList
import com.luisdev.tvphotosapp.data.entities.toPhoto
import com.luisdev.tvphotosapp.data.network.PhotosService
import com.luisdev.tvphotosapp.data.network.api.ApiHandler
import com.luisdev.tvphotosapp.data.network.api.NetworkResult
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoRepositoryImpl @Inject constructor (
    private val photosService: PhotosService
) : PhotoRepository,ApiHandler  {



    override suspend fun getPhotos(query:String, count:Int ): NetworkResult<PhotoList> {
        val service = photosService.getPhotoList( query, count)
        if (service.isSuccessful){
            val list  = service.body()!!.map { item-> item.toPhoto()}
            return handleApi { Response.success(PhotoList(list)) }
        }
        return handleApi { Response.error<PhotoList>(service.code(), service.errorBody()) }
    }

}
