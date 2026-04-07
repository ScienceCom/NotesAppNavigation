package com.example.myprofileapp.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun NoteListScreen(onNoteClick: (Int) -> Unit) {
    Button(onClick = { onNoteClick(1) }) { Text("Notes #1") }
}