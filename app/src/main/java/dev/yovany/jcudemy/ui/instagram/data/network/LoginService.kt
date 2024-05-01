package dev.yovany.jcudemy.ui.instagram.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: LoginClient) {
    suspend fun doLogin(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {

            val response = loginClient.doLogin()
            response.body()?.success ?: false
        }
    }
}