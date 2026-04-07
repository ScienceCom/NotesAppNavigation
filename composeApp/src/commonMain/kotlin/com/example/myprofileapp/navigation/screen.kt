package com.example.myprofileapp.navigation

sealed class Screen(val route: String) {
    // Bottom Nav Tabs
    object Notes : Screen("notes")
    object Favorites : Screen("favorites")
    object Profile : Screen("profile")

    // Other Screens
    object AddNote : Screen("add_note")

    object NoteDetail : Screen("note_detail/{noteId}") {
        fun createRoute(noteId: Int) = "note_detail/$noteId"
    }

    object EditNote : Screen("edit_note/{noteId}") {
        fun createRoute(noteId: Int) = "edit_note/$noteId"
    }
}