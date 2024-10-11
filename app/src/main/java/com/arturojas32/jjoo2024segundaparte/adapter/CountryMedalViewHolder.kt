package com.arturojas32.jjoo2024segundaparte.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.arturojas32.jjoo2024segundaparte.databinding.ItemCountryMedalBinding
import data.Country

class CountryMedalViewHolder(view: View) : ViewHolder(view) {

    private val binding = ItemCountryMedalBinding.bind(view)

    //render se llama por cada item del listado de countries
    fun render(country: Country) {
        binding.tvCountryName.text = country.name
        binding.tvIDCountry.text = country.id.toString()
        binding.tvCountryPos.text = country.position.toString()
        binding.tvCountrySilverMedal.text = country.silverMedals.toString()
        binding.tvCountryGoldMedal.text = country.goldMedals.toString()
        binding.tvCountryBronzeMedal.text = country.bronzeMedals.toString()
//        binding.ivFlagg = country.flag
    }
}