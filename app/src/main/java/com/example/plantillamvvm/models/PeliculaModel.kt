package com.example.plantillamvvm.models

import com.google.gson.annotations.SerializedName

data class PeliculaModel(
    @SerializedName("id")
    var id: Int,
    @SerializedName("original_title")
    var original_title: String,
    @SerializedName("overview")
    var overview: String,
    @SerializedName("poster_path")
    var poster_path: String,
    @SerializedName("release_date")
    var release_date: String,
    @SerializedName("vote_average")
    var vote_average: Double,
    @SerializedName("vote_count")
    var vote_count: String,

)
