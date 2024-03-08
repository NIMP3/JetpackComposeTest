package dev.yovany.jcudemy.ui.menu

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.yovany.jcudemy.Menu
import dev.yovany.jcudemy.Utility
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(@ApplicationContext private val context: Context) : ViewModel() {

    suspend fun getMenu(): Menu? {
        val jsonFileString = Utility.getJsonDataFromAsset(context,"menu.json")
        return try {
            val menu = Gson().fromJson(jsonFileString, Menu::class.java)
            menu
        } catch (e: Exception) {
            null
        }
    }
}