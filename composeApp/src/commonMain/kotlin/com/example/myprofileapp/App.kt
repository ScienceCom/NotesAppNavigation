package com.example.myprofileapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.myprofileapp.navigation.AppNavGraph
import com.example.myprofileapp.ui.MainScreen

@Composable
fun App() {
    MaterialTheme {
        MainScreen()
    }
}