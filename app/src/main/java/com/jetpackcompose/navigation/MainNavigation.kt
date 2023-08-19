package com.jetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetpackcompose.navigation.screens.AboutScreen
import com.jetpackcompose.navigation.screens.ArticlesScreen
import com.jetpackcompose.navigation.screens.SettingsScreen

enum class MainRoute(value: String) {
    Articles("articles"),
    About("about"),
    Settings("settings")
}

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController()
) {

    NavHost(navController = navController, startDestination = MainRoute.Articles.name) {
        composable(MainRoute.Articles.name) {
            ArticlesScreen()
        }
        composable(MainRoute.About.name) {
            AboutScreen()
        }
        composable(MainRoute.Settings.name) {
            SettingsScreen()
        }
    }

}