package com.arturojas32.jjoo2024segundaparte.recyclerViews

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.arturojas32.jjoo2024segundaparte.MenuActivity
import com.arturojas32.jjoo2024segundaparte.R
import com.arturojas32.jjoo2024segundaparte.adapter.CountryMedalAdapter
import com.arturojas32.jjoo2024segundaparte.databinding.ActivityRecyclerviewMedalBinding
import repositories.MedalTableRepository

class RViewMedalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerviewMedalBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_recyclerview_medal)
        binding.customToolbar.tvTitleToolbar.text = getString(R.string.medallero)

        initRecyclerView()
        initListener()

    }

    private fun initListener() {
        binding.customToolbar.ivBack.setOnClickListener {
            val intent = Intent(binding.customToolbar.ivBack.context, MenuActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decorator = DividerItemDecoration(this, manager.orientation)

        binding.rvMedallero.layoutManager = LinearLayoutManager(this)
        binding.rvMedallero.adapter = CountryMedalAdapter(MedalTableRepository.get())
        binding.rvMedallero.addItemDecoration(decorator)
    }
}

