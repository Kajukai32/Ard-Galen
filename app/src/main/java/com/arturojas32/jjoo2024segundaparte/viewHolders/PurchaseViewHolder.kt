package com.arturojas32.jjoo2024segundaparte.viewHolders

import android.view.View
import androidx.core.content.ContextCompat.getString
import androidx.recyclerview.widget.RecyclerView
import com.arturojas32.jjoo2024segundaparte.R
import com.arturojas32.jjoo2024segundaparte.databinding.ItemPurchaseBinding
import data.Purchase

class PurchaseViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPurchaseBinding.bind(view)

    fun render(purchaseModel: Purchase) {

        val idString: String = getString(view.context, R.string.idString)

//        binding.tvIDPurchase.text = purchaseModel.id.toString()
//        binding.tvEventID.text = purchaseModel.eventId.toString()
//        binding.tvAmount.text = purchaseModel.amount.toString()
//        binding.tvSeat.text = purchaseModel.seat.toString()
//        binding.tvCreateDate.text = purchaseModel.createdDate
//        binding.tvUserID.text = purchaseModel.userId.toString()
        binding.tvIDPurchase.text = idString + purchaseModel.id
        binding.tvEventID.text = "ID event: ${purchaseModel.eventId}"
        binding.tvAmount.text = "Cost: ${purchaseModel.amount}"
        binding.tvSeat.text = "Seat: ${purchaseModel.seat}"
        binding.tvCreateDate.text = "Created: ${purchaseModel.createdDate}"
        binding.tvUserID.text = "ID User: ${purchaseModel.userId}"


    }
}
//val string: String = getString(R.string.your_string_id)