package com.sschmitz.samplenav.ui.ext

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

fun NavHostController.switchTabs(route: String) {
  navigate(route) {
    // Pop up to the start destination of the graph to
    // avoid building up a large stack of destinations
    // on the back stack as users select items
    popUpTo(graph.findStartDestination().id) {
      saveState = true
    }
    // Avoid multiple copies of the same destination when
    // reselecting the same item
    launchSingleTop = true
    // Restore state when reselecting a previously selected item
    restoreState = true
  }
}

/**
 * Attempt to pop up to the destination. If the destination is present
 * in the back stack then it will pop up to it. If the destination
 * is not present in the back stack it will navigate to it and remove
 * the current screen from the stack.
 */
fun NavHostController.popUpTo(route: String) {
  try {
    this.getBackStackEntry(route)
    popBackStack(route, false)
  } catch (exception: IllegalArgumentException) {
    navigate(route) {
      currentBackStackEntry?.destination?.route?.let {
        popUpTo(it) {
          inclusive = true
        }
      }
    }
  }
}
