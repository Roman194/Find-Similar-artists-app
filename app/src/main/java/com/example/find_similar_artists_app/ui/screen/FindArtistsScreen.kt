package com.example.find_similar_artists_app.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.find_similar_artists_app.ui.FindArtistUiState
import com.example.find_similar_artists_app.ui.screen.FindArtists.FindArtistsError
import com.example.find_similar_artists_app.ui.screen.FindArtists.FindArtistsLoading
import com.example.find_similar_artists_app.ui.screen.FindArtists.FindArtistsStart
import com.example.find_similar_artists_app.ui.screen.FindArtists.FindArtistsSuccess

@Composable
fun FindArtistsScreen(
    modifier: Modifier = Modifier,
    findArtistsUiState: FindArtistUiState,
    getSimilarArtists : (String) -> Unit
) {
    when (findArtistsUiState) {
        is FindArtistUiState.Loading ->
            FindArtistsLoading(
                originalArtist = findArtistsUiState.originalArtist
            )
        is FindArtistUiState.Start ->
            FindArtistsStart(
                getSimilarArtists = getSimilarArtists
            )
        is FindArtistUiState.Error ->
            FindArtistsError(
                errorMessage = findArtistsUiState.errorMessage,
                originalArtist = findArtistsUiState.originalArtist,
                getSimilarArtists = getSimilarArtists
            )
        is FindArtistUiState.Success ->
            FindArtistsSuccess(
                artistValues = findArtistsUiState.artistUIValues,
                originalArtist = findArtistsUiState.originalArtist,
                getSimilarArtists = getSimilarArtists
            )
    }

}
