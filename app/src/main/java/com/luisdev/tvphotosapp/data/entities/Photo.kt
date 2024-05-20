package com.luisdev.tvphotosapp.data.entities




import com.luisdev.tvphotosapp.data.models.UserResponse
import com.luisdev.tvphotosapp.data.models.PhotosResponse
import com.luisdev.tvphotosapp.data.models.URLResponse
import java.time.LocalDate
import java.time.LocalDateTime


data class Photo(
    val id: String,
    val slug: String,
    val createdAt: LocalDate,
    val updatedAt: LocalDate?,
    val urls: UrlsItem,
    val description: String? ,
    val altDescription: String?,
    val userResponse: User,
)

fun PhotosResponse.toPhoto(): Photo {

    return Photo(
        id,
        slug,
        createdAt,
        updatedAt,
        urls.toUrls(),
        description ,
        altDescription,
        userResponse.toUser(),
    )
}


data class UrlsItem(
    val raw:String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String,
    val smallS3: String
)
fun URLResponse.toUrls(): UrlsItem {

    return UrlsItem(
        raw,
        full,
        regular,
        small,
        thumb,
        smallS3
    )
}


data class User(
    val id: String,
    val username:String,
    val name: String,
    val firstName: String,
    val lastName: String?
)

fun UserResponse.toUser(): User {

    return User(
        id,
        username,
        name,
        firstName,
        lastName
    )
}
