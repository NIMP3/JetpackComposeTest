package dev.yovany.jcudemy.ui.instagram.domain

import dev.yovany.jcudemy.ui.instagram.data.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(email: String, password: String): Boolean {
        return repository.doLogin(email, password)
    }
}