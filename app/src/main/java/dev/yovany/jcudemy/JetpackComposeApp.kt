package dev.yovany.jcudemy

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class JetpackComposeApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}