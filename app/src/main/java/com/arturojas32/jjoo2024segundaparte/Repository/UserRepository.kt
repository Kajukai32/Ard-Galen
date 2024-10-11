package com.arturojas32.jjoo2024segundaparte.Repository

import data.User
import functions.Currentdate

object UserRepository {

    private val users = mutableListOf<User>()

    init {
        users.add(User(1504L, "bbayarri", "abc123", "Brian", "Bayarri", 3500000.50, "2022/12/10"))
        users.add(User(2802L, "AHOZ", "lock_password", "Aylen", "Hoz", 20000.50, "2021/01/11"))
        users.add(User(1510L, "Diegote", "@12345", "Diego", "Gonzalez", 120000.0, "2018/04/15"))
        users.add(User(51L, "Arturojas32", "1472", "Diego", "Gonzalez", 120000.0, "2018/04/15"))
    }


    fun logIn(string: String, password: String): User? {

        return (users.find { it.nickName == string && it.password == password })

    }

    fun signUp(
        nickname: String,
        password: String,
        name: String,
        surname: String,
        money: Double
    ): Boolean {

        return if (logIn(
                nickname,
                password
            ) == null && nickname.isNotBlank() && password.isNotBlank()
        ) {
            users.add(
                User(
                    generateIdUser(),
                    nickname,
                    password,
                    name,
                    surname,
                    money,
                    Currentdate()
                )
            )
        } else {
            false
        }

    }

}


val generateIdUser: () -> Long = { System.currentTimeMillis() }

//import kotlinx.datetime.*
//
//val localDateTime = LocalDateTime(2022, 12, 31, 23, 59, 59) // December 31, 2022, 23:59:59
//val instant = localDateTime.toInstant(ZoneId.systemDefault())
//val millis = instant.toEpochMilli()
//println(millis) // Output: 1672514399000