package com.example.myprofileapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
    onNavigateToDetail: (Int) -> Unit
) {
    Column {
        Button(onClick = { onNavigateToDetail(1) }) { // Kirim ID 1
            Text("Buka Catatan 1")
        }
    }
}