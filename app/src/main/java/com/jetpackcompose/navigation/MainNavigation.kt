package com.jetpackcompose.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Open)
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Box(modifier = Modifier.fillMaxSize().background(Color.Green))
            }
        }
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


}