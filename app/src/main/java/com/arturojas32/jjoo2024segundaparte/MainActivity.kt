package com.arturojas32.jjoo2024segundaparte

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import repositories.UserRepository


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val btnSignUp = findViewById<AppCompatButton>(R.id.btnSignUp)
        val btnLogin = findViewById<AppCompatButton>(R.id.btnLogin)
        val etUser = findViewById<AppCompatEditText>(R.id.etUser)
        val etPassword = findViewById<AppCompatEditText>(R.id.etPassword)

        val user = etUser.text.toString().trim()
        val password = etPassword.text.toString().trim()


        btnSignUp.setOnClickListener { goToSignUpActivity() }
        btnLogin.setOnClickListener { goToLogInActivity(user, password) }

    }

    private fun goToLogInActivity(user: String, password: String) {
//        Toast.makeText(MainActivity.this, "Clicked Button", Toast.LENGTH_SHORT).show()
        if (UserRepository.logIn(user, password) != null) {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(
                this,
                "Error de verificacion",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun goToSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

}

//var LoginWatcher: TextWatcher = object : TextWatcher {
//    override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
//    override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
//        val userName: String = etEmail.getText().toString()
//        val userPass: String = PassEt.getText().toString()
//        button.setEnabled(!userName.isEmpty() && !userPass.isEmpty())
//    }
//
//    override fun afterTextChanged(editable: Editable) {}
//}


//println("Nombre por favor: ")
//nickname = readlnOrNull().toString()
//
//println("Password: ")
//password = readlnOrNull().toString()
//
//Usuario = logIn(nickname, password)
//
//if (Usuario == null) println("usuario inexistente / password incorrecto \n")
//
//} while (Usuario == null)
//
//println("En que puedo ayudarte ${Usuario.name}?")
//menu(Usuario)
//
//}