package com.example.find_similar_artists_app.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.find_similar_artists_app.models.ArtistUI

@Composable
fun SimilarArtistCard(artistUI: ArtistUI){
    Surface (
        shape = MaterialTheme.shapes.medium,
        color= MaterialTheme.colorScheme.surface,
        modifier= Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(
            text = artistUI.name,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 12.dp)
        )
    }
}