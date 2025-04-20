package com.example.find_similar_artists_app.models.data.moshi

import com.example.find_similar_artists_app.models.ArtistUI

data class ArtistMoshi(
    val name: String
)

fun ArtistMoshi.toUI() =
     ArtistUI(
        name = name
    )
