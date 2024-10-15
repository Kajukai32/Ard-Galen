package com.arturojas32.jjoo2024segundaparte.recyclerViews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.arturojas32.jjoo2024segundaparte.adapter.PurchaseAdapter
import com.arturojas32.jjoo2024segundaparte.databinding.ActivityPurchaseHistoryBinding
import functions.purchaseHistory

class RvPurchaseHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPurchaseHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityPurchaseHistoryBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initRecyclerView()

    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.rvPurchaseHistory.layoutManager = LinearLayoutManager(this)
        binding.rvPurchaseHistory.adapter = PurchaseAdapter(purchaseHistory(intent.getLongExtra("idUser", 0L)))
        binding.rvPurchaseHistory.addItemDecoration(decoration)


    }
}
