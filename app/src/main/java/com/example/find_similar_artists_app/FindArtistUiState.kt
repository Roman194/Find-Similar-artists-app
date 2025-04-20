package com.example.find_similar_artists_app

sealed interface FindArtistUiState {
    data class Success(val heroUIValues: List<ArtistUI>): FindArtistUiState
    data class Error(val errorMessage: String): FindArtistUiState
    object Loading: FindArtistUiState
}