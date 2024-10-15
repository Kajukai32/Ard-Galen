package com.arturojas32.jjoo2024segundaparte.viewHolders

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.arturojas32.jjoo2024segundaparte.R
import com.arturojas32.jjoo2024segundaparte.databinding.ItemEventBinding
import data.Event

class EventsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemEventBinding.bind(view)

    fun render(eventModel: Event) {
        binding.tvEventID.text = ContextCompat.getString(view.context, R.string.event_id_resource)+eventModel.id.toString()
        binding.tvEventHour.text = ContextCompat.getString(view.context, R.string.event_hour_resource)+eventModel.hour.toString()
        binding.tvEventPlace.text = ContextCompat.getString(view.context, R.string.event_place_resource)+eventModel.place.toString()
        binding.tvEventPrice.text = ContextCompat.getString(view.context, R.string.event_price_resource)+eventModel.price.toString()
        binding.tvEventSport.text = ContextCompat.getString(view.context, R.string.event_sport_resource)+eventModel.sport.toString()
        binding.tvCreateDate.text = ContextCompat.getString(view.context, R.string.event_created_date_resource)
    }
}
//binding.tvIDPurchase.text = idString + purchaseModel.id
