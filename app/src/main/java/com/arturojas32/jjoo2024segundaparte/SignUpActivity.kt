package com.arturojas32.jjoo2024segundaparte

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arturojas32.jjoo2024segundaparte.databinding.ActivitySignUpBinding
import com.arturojas32.jjoo2024segundaparte.repository.UserRepository.signUp
import functions.displayToast

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initComponents()
        initListeners()


    }


    private fun initListeners() {
        binding.trySignUpBtn.setOnClickListener {
            val nickname = binding.etNicknameNewUser.text.toString().trim()
            val password = binding.etNewUserPassword.text.toString().trim()
            val surname = binding.etSurnameNewUser.text.toString()
            val name = binding.etNameNewUser.text.toString()
            val money = 0.0


            if (signUp(nickname, password, name, surname, money)) {

                displayToast("succesfull", this)
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)


            } else {
                displayToast("Sign up failed", this)
            }
        }
    }


    private fun initComponents() {


    }
}
