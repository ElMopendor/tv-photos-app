package com.luisdev.tvphotosapp.data.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Serializable
data class PhotosResponse(
    val id: String,
    val slug: String,
    @SerialName("created_at")
    @Serializable(with = LocalDateTimeSerializer::class)
    val createdAt: LocalDate,
    @SerialName("updated_at")
    @Serializable(with = LocalDateTimeSerializer::class)
    val updatedAt: LocalDate?,
    val urls: URLResponse,
    val description: String?,
    @SerialName("alt_description")
    val altDescription: String?,
    @SerialName("user")
    val userResponse: UserResponse,

    )


@Serializable
data class URLResponse(
    val raw:String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String,
    @SerialName("small_s3")
    val smallS3: String
)

@Serializable
data class UserResponse(
    val id: String,
    val username:String,
    val name: String,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String?
)


@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = LocalDate::class)
class LocalDateTimeSerializer : KSerializer<LocalDate> {
    private val formatter: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    override fun serialize(encoder: Encoder, value: LocalDate) {
        encoder.encodeString(value.format(formatter))
    }

    override fun deserialize(decoder: Decoder): LocalDate {
        try {
            val decoded = decoder.decodeString()
            if(  decoded != "" ){
                val date =  LocalDate.parse(decoded.substring(0,10), DateTimeFormatter.ofPattern("yyyy-MM-dd"))

                return date
            }
            return LocalDate.now()
        }
        catch (e:Exception) {
            return LocalDate.now()
        }
    }
}


