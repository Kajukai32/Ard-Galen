package com.arturojas32.jjoo2024segundaparte.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arturojas32.jjoo2024segundaparte.R
import com.arturojas32.jjoo2024segundaparte.viewHolders.EventsViewHolder
import data.Event

class EventsAdapter(private val eventlist: List<Event>) : RecyclerView.Adapter<EventsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return EventsViewHolder(layoutInflater.inflate(R.layout.activity_rv_events, parent, false))
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = eventlist.size
}