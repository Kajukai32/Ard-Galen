package com.arturojas32.jjoo2024segundaparte

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arturojas32.jjoo2024segundaparte.RecyclerViews.RViewMedalActivity
import com.arturojas32.jjoo2024segundaparte.databinding.ActivityMenuBinding
import repositories.MedalTableRepository

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        MedalTableRepository.get()

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        binding.btnMedallero.setOnClickListener {
            val intent = Intent(this, RViewMedalActivity::class.java)
            startActivity(intent)

        }
    }


}
