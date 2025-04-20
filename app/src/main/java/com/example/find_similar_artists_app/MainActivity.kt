package com.example.find_similar_artists_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.find_similar_artists_app.ui.screen.FindArtistsScreen
import com.example.find_similar_artists_app.ui.FindArtistsViewModel
import com.example.find_similar_artists_app.ui.theme.Find_Similar_Artists_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Find_Similar_Artists_AppTheme {
                val findArtistsViewModel: FindArtistsViewModel = viewModel()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FindArtistsScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        findArtistsUiState = findArtistsViewModel.findArtistsUiState,
                        getSimilarArtists = {
                            findArtistsViewModel.getSimilarArtists(it)
                        }
                    )
                }
            }
        }
    }
}