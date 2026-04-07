package com.example.myprofileapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object NoteList : Screen("note_list")

    // Rute dengan argumen (Latihan 2)
    object NoteDetail : Screen("note_detail/{noteId}") {
        fun createRoute(noteId: Int) = "note_detail/$noteId"
    }
}