package com.example.find_similar_artists_app.ui

import com.example.find_similar_artists_app.models.ArtistUI

sealed interface FindArtistUiState {
    data class Success(val artistUIValues: List<ArtistUI>, val originalArtist: String):
        FindArtistUiState
    data class Error(val errorMessage: String, val originalArtist: String): FindArtistUiState
    data class Loading(val originalArtist: String): FindArtistUiState
    object Start: FindArtistUiState
}