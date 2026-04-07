package com.example.myprofileapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myprofileapp.components.AppBottomBar
import com.example.myprofileapp.navigation.AppNavGraph
import com.example.myprofileapp.navigation.Screen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            AppBottomBar(navController = navController)
        },
        floatingActionButton = {
            if (currentRoute == Screen.Notes.route) {
                FloatingActionButton(onClick = { navController.navigate(Screen.AddNote.route) }) {
                    Icon(Icons.Default.Add, contentDescription = "Add Note")
                }
            }
        }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            AppNavGraph(navController = navController)
        }
    }
}