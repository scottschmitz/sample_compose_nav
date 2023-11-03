package com.sschmitz.samplenav.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sschmitz.samplenav.ui.Route
import com.sschmitz.samplenav.ui.home.HomeDetails
import com.sschmitz.samplenav.ui.home.HomeDetailsExtra
import com.sschmitz.samplenav.ui.home.HomeOverview

fun NavGraphBuilder.homeGraph(navController: NavHostController) {
    navigation(
        startDestination = Route.HOME_OVERVIEW,
        route = Route.HOME_ROOT
    ) {
        composable(Route.HOME_OVERVIEW) {
            HomeOverview(
                toDetails = { navController.navigate(Route.HOME_DETAILS) },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }

        composable(Route.HOME_DETAILS) {
            HomeDetails(
                toExtraDetails = { navController.navigate(Route.HOME_DETAILS_EXTRA) },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }

        composable(Route.HOME_DETAILS_EXTRA) {
            HomeDetailsExtra(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }
    }
}
