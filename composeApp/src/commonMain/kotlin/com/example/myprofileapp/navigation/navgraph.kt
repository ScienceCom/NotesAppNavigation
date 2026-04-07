package com.example.myprofileapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
// Import screen anda
import com.example.myprofileapp.ui.HomeScreen
import com.example.myprofileapp.ui.NoteDetailScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        // Latihan 1: Home Screen
        composable(Screen.Home.route) {
            HomeScreen(onNavigateToDetail = { idCatatan ->
                navController.navigate(Screen.NoteDetail.createRoute(idCatatan))
            })
        }

        // Latihan 2: Detail Screen dengan ID
        composable(
            route = Screen.NoteDetail.route,
            arguments = listOf(navArgument("noteId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("noteId") ?: 0
            NoteDetailScreen(
                noteId = id,
                onBack = { navController.popBackStack() }
            )
        }
    }
}