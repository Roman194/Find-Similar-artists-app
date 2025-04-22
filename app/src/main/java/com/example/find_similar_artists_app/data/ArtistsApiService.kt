package com.example.find_similar_artists_app.data

import com.example.find_similar_artists_app.BuildConfig
import com.example.find_similar_artists_app.data.Either.Either
import com.example.find_similar_artists_app.data.Either.EitherCallAdapterFactory
import com.example.find_similar_artists_app.models.data.ErrorResponse
import com.example.find_similar_artists_app.models.data.moshi.MoshiResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtistsApiService {

}
