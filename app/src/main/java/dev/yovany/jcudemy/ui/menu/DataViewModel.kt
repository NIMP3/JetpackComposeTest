package dev.yovany.jcudemy.ui.menu

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.yovany.jcudemy.Utility
import dev.yovany.jcudemy.data.Menu
import dev.yovany.jcudemy.data.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(@ApplicationContext private val context: Context) : ViewModel() {

    private val _menu = MutableStateFlow<Resource<Menu>>(Resource.Empty(null))
    val menu: StateFlow<Resource<Menu>> = _menu

    suspend fun getMenu() {
        _menu.value = Resource.Loading()

        delay(3000)
        val jsonFileString = Utility.getJsonDataFromAsset(context,"menu.json")
        return try {
            val menu = Gson().fromJson(jsonFileString, Menu::class.java)
            _menu.value = Resource.Success(menu)
        } catch (e: Exception) {
            _menu.value = Resource.Error(null, e.message ?: "Error parsing JSON")
        }
    }
}