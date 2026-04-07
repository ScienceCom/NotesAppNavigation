package com.example.myprofileapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.myprofileapp.navigation.AppNavGraph

@Composable
fun App() {
    MaterialTheme {
        // Buat NavController di level atas
        val navController = rememberNavController()

        // Panggil NavGraph
        AppNavGraph(navController = navController)
    }
}