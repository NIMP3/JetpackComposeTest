package dev.yovany.jcudemy.ui.instagram.data

import dev.yovany.jcudemy.ui.instagram.data.network.LoginService

class LoginRepository {
    private val api = LoginService()

    suspend fun doLogin(email: String, password: String): Boolean {
        return api.doLogin(email, password)
    }
}