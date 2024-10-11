package com.arturojas32.jjoo2024segundaparte

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arturojas32.jjoo2024segundaparte.Repository.UserRepository
import com.arturojas32.jjoo2024segundaparte.databinding.ActivityMainBinding
import functions.displayToast


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private lateinit var user: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initComponents()
        initListeners()

        binding.tvForgottenPassword.setOnClickListener { displayToast("te jodés", this) }


    }

    private fun initListeners() {

        binding.btnLogin.setOnClickListener { goToLogInActivity() }
        binding.btnSignUp.setOnClickListener { goToSignUpActivity() }

    }

    private fun initComponents() {


    }

    private fun goToLogInActivity() {
        user = binding.etUser.text.toString()
        password = binding.etPassword.text.toString()


        if (UserRepository.logIn(user, password) != null) {
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("usuario", user)
            intent.putExtra("password", password)
            startActivity(intent)
        } else {
            displayToast("Log in failed", this)
        }
    }

    private fun goToSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

}

