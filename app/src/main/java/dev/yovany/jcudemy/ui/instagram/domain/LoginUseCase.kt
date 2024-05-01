package dev.yovany.jcudemy.ui.instagram.domain

import dev.yovany.jcudemy.ui.instagram.data.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository) {
    suspend operator fun invoke(email: String, password: String): Boolean {
        return repository.doLogin(email, password)
    }
}