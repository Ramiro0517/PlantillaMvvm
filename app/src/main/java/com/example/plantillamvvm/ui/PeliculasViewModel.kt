package com.example.plantillamvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantillamvvm.core.Constants
import com.example.plantillamvvm.models.PeliculaModel
import com.example.plantillamvvm.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PeliculasViewModel: ViewModel() {

    private var _listaPeliculas = MutableLiveData<List<PeliculaModel>>()
    val listaPeliculas: LiveData<List<PeliculaModel>> get() = _listaPeliculas

    fun obtenerCartelera(){
        viewModelScope.launch(Dispatchers.IO){
            val response =RetrofitClient.webService.getNowPlaying(Constants.API_KEY)
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    _listaPeliculas.value = response.body()!!.resultados.sortedByDescending {   it.vote_average}

                }
            }
        }
    }
    fun obtenerPopulares(){
        viewModelScope.launch(Dispatchers.IO){
            val response =RetrofitClient.webService.getPopular(Constants.API_KEY)
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    _listaPeliculas.value = response.body()!!.resultados.sortedByDescending {   it.vote_average}

                }
            }
        }
    }
}