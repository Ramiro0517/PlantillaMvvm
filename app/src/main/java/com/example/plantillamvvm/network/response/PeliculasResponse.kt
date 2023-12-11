package com.example.plantillamvvm.network.response

import com.example.plantillamvvm.models.PeliculaModel
import com.google.gson.annotations.SerializedName

data class PeliculasResponse(
    @SerializedName("results")
    var resultados: List<PeliculaModel>
)