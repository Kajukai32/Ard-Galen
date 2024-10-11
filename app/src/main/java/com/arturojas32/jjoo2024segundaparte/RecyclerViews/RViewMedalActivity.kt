package com.arturojas32.jjoo2024segundaparte.RecyclerViews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arturojas32.jjoo2024segundaparte.adapter.CountryMedalAdapter
import com.arturojas32.jjoo2024segundaparte.databinding.ActivityRecyclerviewMedalBinding
import repositories.MedalTableRepository

class RViewMedalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerviewMedalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecyclerviewMedalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvMedallero.layoutManager = LinearLayoutManager(this)
        binding.rvMedallero.adapter = CountryMedalAdapter(MedalTableRepository.get())
    }
}

