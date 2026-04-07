package com.example.myprofileapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myprofileapp.navigation.Screen

@Composable
fun AppBottomBar(navController: NavHostController) {
    val tabs = listOf(
        Triple(Screen.Notes.route, Icons.Default.List, "Notes"),
        Triple(Screen.Favorites.route, Icons.Default.Favorite, "Favorites"),
        Triple(Screen.Profile.route, Icons.Default.Person, "Profile")
    )

    NavigationBar {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry.value?.destination

        tabs.forEach { (route, icon, label) ->
            NavigationBarItem(
                icon = { Icon(icon, contentDescription = label) },
                label = { Text(label) },
                selected = currentDestination?.hierarchy?.any { it.route == route } == true,
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
}