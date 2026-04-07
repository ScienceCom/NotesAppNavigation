package com.example.myprofileapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.myprofileapp.screens.*

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Notes.route
    ) {
        // Tab 1: Notes List
        composable(Screen.Notes.route) {
            NoteListScreen(
                onNoteClick = { id -> navController.navigate(Screen.NoteDetail.createRoute(id)) }
            )
        }

        // Tab 2: Favorites
        composable(Screen.Favorites.route) { FavoritesScreen() }

        // Tab 3: Profile
        composable(Screen.Profile.route) { ProfileScreen() }

        // Add Note
        composable(Screen.AddNote.route) {
            AddNoteScreen(onBack = { navController.popBackStack() })
        }

        // Note Detail
        composable(
            route = Screen.NoteDetail.route,
            arguments = listOf(navArgument("noteId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("noteId") ?: 0
            NoteDetailScreen(
                noteId = id,
                onEditClick = { navController.navigate(Screen.EditNote.createRoute(id)) },
                onBack = { navController.popBackStack() }
            )
        }

        // Edit Note
        composable(
            route = Screen.EditNote.route,
            arguments = listOf(navArgument("noteId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("noteId") ?: 0
            EditNoteScreen(noteId = id, onBack = { navController.popBackStack() })
        }
    }
}