package com.example.find_similar_artists_app.models.data.moshi

import com.squareup.moshi.Json

data class MoshiResponseData(
    @Json(name = "results")
    val results: List<ArtistMoshi>
)
