package com.example.plantillamvvm.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.plantillamvvm.R
import com.example.plantillamvvm.core.Constants
import com.example.plantillamvvm.models.PeliculaModel

class PeliculasAdapter(
    val context : Context,
    val listaPeliculas : ArrayList<PeliculaModel>
) :RecyclerView.Adapter<PeliculasAdapter.ViewHolder>() {

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val cvPeliculas = itemview.findViewById<View>(R.id.cvPeliculas) as CardView
        val ivPoster = itemview.findViewById<View>(R.id.poster) as ImageView
        val pcIndicador = itemview.findViewById<View>(R.id.circular_progress) as CircularProgressIndicator
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.item_rv_peliculas,parent,false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val pelicula = listaPeliculas[position]
           Glide
               .with(context)
               .load("${Constants.BASE_URL_IMAGE}${pelicula.poster_path}")
               .apply (RequestOptions().override(Constants.IMAGE_ANCHO, Constants.IMAGE_ALTO) )
                .into(holder.ivPoster)

        holder.pcIndicador.maxProgress = Constants.MAX_CALIFICATION
        holder.pcIndicador.setCurrentProgress(pelicula.vote_count.toDouble())
    }

    override fun getItemCount(): Int {
        return listaPeliculas.size
    }
}