package com.arturojas32.jjoo2024segundaparte

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arturojas32.jjoo2024segundaparte.databinding.ActivityMenuBinding
import com.arturojas32.jjoo2024segundaparte.recyclerViews.RvPurchaseHistoryActivity
import com.arturojas32.jjoo2024segundaparte.recyclerViews.RViewMedalActivity
import functions.displayToast
import functions.purchaseHistory
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
        binding.btnPurchHistory.setOnClickListener {

            val usuario = intent.getStringExtra("usuario")
            val idUser = intent.getLongExtra("idUser", 0L)

            if (purchaseHistory(idUser).isNotEmpty()) {
                displayToast(usuario!!, this)
                goToPurchasehistory(idUser)
            } else {
                displayToast("any purchases yet", this)
            }
        }
    }

    private fun goToPurchasehistory(idUser: Long) {
        val intent = Intent(this, RvPurchaseHistoryActivity::class.java)
        intent.putExtra("idUser", idUser)
        startActivity(intent)
    }


}
