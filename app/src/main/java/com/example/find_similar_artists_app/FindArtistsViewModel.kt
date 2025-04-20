package com.example.find_similar_artists_app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FindArtistsViewModel: ViewModel() {

    private var _reserveArtistsUIState = MutableStateFlow(listOf( ArtistUI()))
    val reserveHeroUIState: StateFlow<List<ArtistUI>> = _reserveArtistsUIState.asStateFlow()

    var findArtistsUiState: FindArtistUiState by mutableStateOf(FindArtistUiState.Loading)

    fun getSimilarArtists(){
        _reserveArtistsUIState.value = SampleData.sampleArtists

        findArtistsUiState =
            FindArtistUiState.Success(
                heroUIValues = _reserveArtistsUIState.value
            )

    }
}