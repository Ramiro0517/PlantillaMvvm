package com.example.plantillamvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.plantillamvvm.R
import com.example.plantillamvvm.databinding.ActivityMainBinding
import com.example.plantillamvvm.ui.adapters.PeliculasAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var peliculasViewModel: PeliculasViewModel
    private lateinit var peliculasAdapter: PeliculasAdapter
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        peliculasViewModel = ViewModelProvider(this)[PeliculasViewModel::class.java]

        setupReciclerView()

        

    }

    private fun setupReciclerView() {
        val layoutManager = GridLayoutManager(this,3)
        binding.rvPeliculas.layoutManager = layoutManager
        peliculasAdapter = PeliculasAdapter(this, arrayListOf())
        binding.rvPeliculas.adapter = peliculasAdapter
    }
}