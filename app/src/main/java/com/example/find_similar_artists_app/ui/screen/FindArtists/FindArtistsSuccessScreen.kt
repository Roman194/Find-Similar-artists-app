package com.example.find_similar_artists_app.ui.screen.FindArtists

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.find_similar_artists_app.models.ArtistUI
import com.example.find_similar_artists_app.ui.components.ArtistTextField
import com.example.find_similar_artists_app.ui.components.SimilarArtistCard

@Composable
fun FindArtistsSuccess(
    artistValues: List<ArtistUI>,
    originalArtist: String,
    getSimilarArtists: (String) -> Unit
) {
    Column{

        ArtistTextField(
            isEnabled = true,
            originalArtist = originalArtist,
            getSimilarArtists = getSimilarArtists
        )

        Text(
            text = "Similar Artists:",
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 64.dp, end = 16.dp),
        ){
            itemsIndexed(artistValues) { index,artist -> //this construction optimize creation of similar reviews elements

                SimilarArtistCard(
                    artistUI = artist
                )

                if(index < artistValues.lastIndex){
                    HorizontalDivider(
                        thickness = 2.dp,
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(
                                top=12.dp,
                                bottom = 10.dp,
                                start = 24.dp,
                                end = 24.dp
                            )
                    )
                }
            }
        }
    }

}