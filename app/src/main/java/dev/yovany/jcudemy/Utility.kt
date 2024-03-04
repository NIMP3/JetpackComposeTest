package dev.yovany.jcudemy

import android.content.Context
import android.graphics.Color
import java.io.IOException

class Utility {
    companion object {
        fun getJsonDataFromAsset(context: Context, fileName: String) : String? {
            val jsonString: String
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                return  null
            }

            return jsonString
        }

        fun getColorFromString(color: String): Int? {
            return try {
                Color.parseColor(color)
            } catch (e: Exception) {
                null
            }
        }

        fun getResourceId(context: Context, name: String, type: String): Int? {
            return try {
                val resource = context.resources.getIdentifier(name, type, context.packageName)
                if (resource == 0) null else resource
            } catch (e: Exception) {
                null
            }
        }
    }
}