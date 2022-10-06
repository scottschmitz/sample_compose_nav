package com.sschmitz.samplenav.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.sschmitz.samplenav.ui.ext.switchTabs
import com.sschmitz.samplenav.ui.navigation.NavigationTree

@Composable
fun BottomNav(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        NavigationTree.values().forEach { tree ->
            NavigationBarItem(
                icon = { Icon(tree.image, contentDescription = stringResource(tree.displayName)) },
                label = { Text(stringResource(tree.displayName)) },
                selected = currentDestination?.hierarchy?.any { it.route == tree.route } == true,
                onClick = {
                    when (currentDestination?.hierarchy?.any { it.route == tree.route } == true) {
                        true -> {
                            if (currentDestination?.route != tree.startDestinationRoute) {
                                navController.navigate(route = tree.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        inclusive = false
                                    }
                                }
                            }
                        }
                        else -> navController.switchTabs(tree.route)
                    }
                }
            )
        }
    }
}
