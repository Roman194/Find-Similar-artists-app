package com.example.find_similar_artists_app.ui.screen.FindArtists

import androidx.compose.runtime.Composable
import com.example.find_similar_artists_app.ui.components.ArtistTextField

@Composable
fun FindArtistsStart(
    getSimilarArtists: (String) -> Unit
) {

    ArtistTextField(
        isEnabled = true,
        getSimilarArtists = getSimilarArtists
    )
}