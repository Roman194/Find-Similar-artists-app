package com.example.find_similar_artists_app.data

import com.example.find_similar_artists_app.data.Either.Either
import com.example.find_similar_artists_app.data.Either.EitherCallAdapterFactory
import com.example.find_similar_artists_app.models.data.ErrorResponse
import com.example.find_similar_artists_app.models.data.moshi.MoshiResponse
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://tastedive.com/api/"

val moshi = Moshi.Builder()
    .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .client(client)
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(
        MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(EitherCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface ArtistsApiService {

    @GET("similar")
    suspend fun getSimilarArtists(
        @Query("k") apiKey: String = ParseConstants.API_KEY,
        @Query("q") originalArtistName: String,
        @Query("type") type: String = "music"
    ): Either<ErrorResponse, MoshiResponse>//String

}

object ArtistsApi {
    val artistsRetrofitService: ArtistsApiService by lazy {
        retrofit.create(ArtistsApiService::class.java)
    }
}