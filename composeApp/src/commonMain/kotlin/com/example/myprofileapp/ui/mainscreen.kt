package com.example.myprofileapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.example.myprofileapp.navigation.*

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                val tabs = listOf(
                    Triple(Screen.Notes.route, Icons.Default.List, "Notes"),
                    Triple(Screen.Favorites.route, Icons.Default.Favorite, "Favs"),
                    Triple(Screen.Profile.route, Icons.Default.Person, "Profile")
                )
                tabs.forEach { (route, icon, label) ->
                    NavigationBarItem(
                        selected = currentRoute == route,
                        label = { Text(label) },
                        icon = { Icon(icon, contentDescription = null) },
                        onClick = {
                            navController.navigate(route) {
                                popUpTo(Screen.Notes.route) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        },
        floatingActionButton = {
            if (currentRoute == Screen.Notes.route) {
                FloatingActionButton(onClick = { navController.navigate(Screen.AddNote.route) }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            AppNavGraph(navController = navController)
        }
    }
}