package br.senai.catalogoaprender

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.catalogoaprender.ui.screens.CadastroCursos
import br.senai.catalogoaprender.ui.screens.CatalogScreen
import br.senai.catalogoaprender.ui.screens.DetailsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Catalog"
    ) {
        composable("Catalog") {
            CatalogScreen(navController = navController)
        }

        composable("CourseRegister") {
            CadastroCursos(navController = navController)
        }

        composable("Details/{courseId}") { backStackEntry ->
            val courseId = backStackEntry.arguments
                ?.getString("courseId")
                ?.toIntOrNull()
                ?: -1

            DetailsScreen(
                courseId = courseId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}