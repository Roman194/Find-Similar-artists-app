package com.example.find_similar_artists_app.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ArtistTextField(
    isEnabled: Boolean,
    originalArtist: String = "",
    getSimilarArtists: (String) -> Unit
) {
    var originalArtistName by remember { mutableStateOf(originalArtist) }
    //var isClicked by remember { mutableStateOf(false) }

    // Layout to organize the TextField and the Text below it
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 32.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Find Similar Artists",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 32.dp, bottom = 16.dp),
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        // TextField for user input
        TextField(
            value = originalArtistName,
            onValueChange = { originalArtistName = it },
            label = { Text("Enter your artist") },
            enabled = isEnabled,
            maxLines = 1,
            singleLine = true,
            trailingIcon = {
                androidx.compose.material3.Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Info Icon",
                    tint = Color.Gray,
                    modifier = Modifier.clickable {
                        getSimilarArtists(originalArtistName)
                    }
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

    }
}