package com.example.find_similar_artists_app.ui.screen.FindArtists

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.find_similar_artists_app.ui.components.ArtistTextField

@Composable
fun FindArtistsLoading(
    originalArtist:String
){
    Column {
        ArtistTextField(
            isEnabled = false,
            originalArtist = originalArtist,
            getSimilarArtists = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Loading...",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
    }

}