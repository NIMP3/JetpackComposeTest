package dev.yovany.jcudemy.ui.instagram.data

import dev.yovany.jcudemy.ui.instagram.data.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: LoginService) {
    suspend fun doLogin(email: String, password: String): Boolean {
        return api.doLogin(email, password)
    }
}