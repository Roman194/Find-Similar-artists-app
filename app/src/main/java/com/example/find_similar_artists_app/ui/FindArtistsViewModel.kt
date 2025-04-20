package com.example.find_similar_artists_app.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.find_similar_artists_app.models.ArtistUI
import com.example.find_similar_artists_app.assets.SampleData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FindArtistsViewModel: ViewModel() {

    private var _reserveArtistsUIState = MutableStateFlow(listOf( ArtistUI()))
    val reserveHeroUIState: StateFlow<List<ArtistUI>> = _reserveArtistsUIState.asStateFlow()

    var findArtistsUiState: FindArtistUiState by mutableStateOf(FindArtistUiState.Start)

    fun getSimilarArtists(originalArtistName: String){
        _reserveArtistsUIState.value = SampleData.sampleArtists

        findArtistsUiState = FindArtistUiState.Loading(
            originalArtist = originalArtistName
        )

        if(originalArtistName.isEmpty()){
            findArtistsUiState = FindArtistUiState.Error(
                errorMessage = "Please enter an artist name",
                originalArtist = originalArtistName
            )
        }else{
            findArtistsUiState =
                FindArtistUiState.Success(
                    artistUIValues = _reserveArtistsUIState.value,
                    originalArtist = originalArtistName
                )
        }


    }
}