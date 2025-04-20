package com.example.find_similar_artists_app.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.find_similar_artists_app.data.ArtistsApi
import com.example.find_similar_artists_app.data.Either.Either
import com.example.find_similar_artists_app.models.data.toStringType
import com.example.find_similar_artists_app.models.data.moshi.toUI
import kotlinx.coroutines.launch

class FindArtistsViewModel: ViewModel() {

    //private var _reserveArtistsUIState = MutableStateFlow(listOf( ArtistUI()))
    //val reserveHeroUIState: StateFlow<List<ArtistUI>> = _reserveArtistsUIState.asStateFlow()

    var findArtistsUiState: FindArtistUiState by mutableStateOf(FindArtistUiState.Start)

    fun getSimilarArtists(originalArtistName: String){
        //_reserveArtistsUIState.value = SampleData.sampleArtists

        viewModelScope.launch {
            findArtistsUiState = FindArtistUiState.Loading(
                originalArtist = originalArtistName
            )

            if (originalArtistName.isEmpty()) {
                findArtistsUiState = FindArtistUiState.Error(
                    errorMessage = "Please enter an artist name",
                    originalArtist = originalArtistName
                )
            }else{
                val response = ArtistsApi.artistsRetrofitService.getSimilarArtists(
                    originalArtistName =
                        convertArtistNameToQueryFormat(
                            artistName = originalArtistName
                        )
                )

                findArtistsUiState = //FindArtistUiState.Error(errorMessage = response, originalArtist = originalArtistName)
                    when (response){
                        is Either.Fail ->
                            FindArtistUiState.Error(
                                errorMessage = response.value.toStringType(),
                                originalArtist = originalArtistName
                            )

                        is Either.Success ->
                            FindArtistUiState.Success(
                                artistUIValues = response.value.similar.results.map {similarArtists->
                                    similarArtists.toUI()
                                },
                                originalArtist = originalArtistName
                            )
                    }
            }
        }

    }

    private fun convertArtistNameToQueryFormat(artistName: String): String {
        return artistName.trim().replace(" ", "+")
    }
}