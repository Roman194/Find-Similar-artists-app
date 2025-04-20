package com.example.find_similar_artists_app.data

import com.example.find_similar_artists_app.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class ParseConstants{
    companion object{
        const val API_KEY = BuildConfig.TASTE_DIVE_API_KEY
    }
}

val loggingInterceptor = HttpLoggingInterceptor()
    .apply {
        setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

val client = OkHttpClient.Builder()
    .addNetworkInterceptor(loggingInterceptor)
    .build()