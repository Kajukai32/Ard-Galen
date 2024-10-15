package com.arturojas32.jjoo2024segundaparte.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arturojas32.jjoo2024segundaparte.R
import com.arturojas32.jjoo2024segundaparte.viewHolders.PurchaseViewHolder
import data.Purchase

//agarra el listado que le pasemos y lo vuelve un recycler view
class PurchaseAdapter(private val listOfPurchases: List<Purchase>) :
    RecyclerView.Adapter<PurchaseViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PurchaseViewHolder(layoutInflater.inflate(R.layout.item_purchase, parent, false))
    }

    override fun getItemCount(): Int = listOfPurchases.size

    override fun onBindViewHolder(holder: PurchaseViewHolder, position: Int) {
        val item = listOfPurchases[position]
        holder.render(item)
    }
}