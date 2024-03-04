package dev.yovany.jcudemy

import android.content.Context
import com.google.gson.Gson

data class Menu(
    val title: String,
    val subtitle: String,
    val resource : String,
    val services: List<Service>
) {
    companion object {
        fun getMenuFromJSON(context: Context): Menu? {
            val jsonFileString = Utility.getJsonDataFromAsset(context,"menu.json")
            return try {
                val menu = Gson().fromJson(jsonFileString, Menu::class.java)
                menu
            } catch (e: Exception) {
                null
            }
        }

        fun createSimpleMenu(): Menu {
            return Menu(
                "Jetpack Compose",
                "Project to learn Jetpack Compose",
                "ic_jetpack_compose",
                listOf(
                    Service(
                        1,
                        "Components",
                        "Components to build the UI",
                        "ic_components",
                        "#FF6200EE",
                        listOf(
                            Item(1, "Text", "A composable that displays a string of text."),
                            Item(2, "Button", "A composable that responds to user clicks."),
                            Item(3, "Image", "A composable that displays a drawable."),
                            Item(4, "Card", "A composable that is a container with elevation and corner radius.")
                        )
                    ),
                    Service(
                        2,
                        "Layouts",
                        "Compose layouts",
                        "ic_layouts",
                        "#FF03DAC5",
                        listOf(
                            Item(5, "Column", "A composable that places its children in a vertical sequence."),
                            Item(6, "Row", "A composable that places its children in a horizontal sequence."),
                            Item(7, "Box", "A composable that places its children in a stack.")
                        )
                    ),
                    Service(
                        3,
                        "Material",
                        "Material Design components",
                        "ic_material",
                        "#FF018786",
                        listOf(
                            Item(8, "TopAppBar", "A composable that provides a top app bar."),
                            Item(9, "BottomAppBar", "A composable that provides a bottom app bar."),
                            Item(10, "FloatingActionButton", "A composable that provides a floating action button.")
                        )
                    ),
                )
            )

        }
    }
}

data class Service(
    val id: Int,
    val service: String,
    val description: String,
    val resource: String,
    val color: String,
    val items: List<Item>
)

data class Item(
    val id: Int,
    val name: String,
    val description: String
)