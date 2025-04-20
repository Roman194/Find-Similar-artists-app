package com.example.find_similar_artists_app.ui.screen.FindArtists

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.find_similar_artists_app.ui.components.ArtistTextField

@Composable
fun FindArtistsError(
    errorMessage: String,
    originalArtist: String,
    getSimilarArtists: (String) -> Unit
) {
    Column{
        ArtistTextField(
            isEnabled = true,
            originalArtist = originalArtist,
            getSimilarArtists = getSimilarArtists
        )

        Spacer(modifier = Modifier.height(16.dp))

        Surface(
            color = MaterialTheme.colorScheme.error,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ){
            Text(
                text = errorMessage,
                color = androidx.compose.ui.graphics.Color.White,
                modifier = Modifier.padding(16.dp)
            )
        }
    }

}