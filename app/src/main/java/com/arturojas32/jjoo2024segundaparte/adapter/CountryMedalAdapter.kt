package com.arturojas32.jjoo2024segundaparte.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arturojas32.jjoo2024segundaparte.R
import data.Country

class CountryMedalAdapter(private val listCountriesByMedals: List<Country>) :
    RecyclerView.Adapter<CountryMedalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryMedalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CountryMedalViewHolder(
            layoutInflater.inflate(
                R.layout.item_country_medal,
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int = listCountriesByMedals.size

    override fun onBindViewHolder(holder: CountryMedalViewHolder, position: Int) {
        val item = listCountriesByMedals[position]
        holder.render(item)
    }
}