package com.example.plantillamvvm.network

import com.example.plantillamvvm.network.response.PeliculasResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") apiKey: String,
    ): Response<PeliculasResponse>

    @GET("popular")
    suspend fun getPopular(
        @Query("api_key") apiKey: String,
    ): Response<PeliculasResponse>

}