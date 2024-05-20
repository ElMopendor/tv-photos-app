package com.luisdev.tvphotosapp.data.entities

import androidx.compose.runtime.Immutable

@Immutable
data class PhotoList(
    val value: List<Photo> = emptyList()
) : List<Photo> by value