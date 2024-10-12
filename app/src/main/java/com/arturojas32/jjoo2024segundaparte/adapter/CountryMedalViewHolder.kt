package com.arturojas32.jjoo2024segundaparte.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.arturojas32.jjoo2024segundaparte.databinding.ItemCountryMedalBinding
import com.bumptech.glide.Glide
import data.Country
import functions.displayToast

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
        Glide.with(binding.ivFlagg.context).load(country.flag).into(binding.ivFlagg)

        binding.tvCountryName.setOnClickListener {
            displayToast("country name", binding.ivFlagg.context)
        }
        binding.tvIDCountry.setOnClickListener {
            displayToast("country ID", binding.ivFlagg.context)
        }
        binding.tvCountryPos.setOnClickListener {
            displayToast("country position", binding.ivFlagg.context)
        }
        binding.tvCountryGoldMedal.setOnClickListener {
            displayToast("gold medals", binding.ivFlagg.context)
        }
        binding.tvCountrySilverMedal.setOnClickListener {
            displayToast("silver medal", binding.ivFlagg.context)
        }
        binding.tvCountryBronzeMedal.setOnClickListener {
            displayToast("bronze medals", binding.ivFlagg.context)
        }
        binding.ivFlagg.setOnClickListener {
            displayToast("current country flag", binding.ivFlagg.context)
        }

    }
}