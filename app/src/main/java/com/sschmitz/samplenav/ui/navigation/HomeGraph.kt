package com.sschmitz.samplenav.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sschmitz.samplenav.R
import com.sschmitz.samplenav.ui.Route

fun NavGraphBuilder.homeGraph(navController: NavHostController) {
    navigation(
        startDestination = Route.HOME_OVERVIEW,
        route = Route.HOME_ROOT
    ) {
        composable(Route.HOME_OVERVIEW) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = stringResource(id = R.string.home_overview_title),
                    style = MaterialTheme.typography.headlineMedium
                )
                Button(onClick = { navController.navigate(Route.HOME_DETAILS) } ) {
                    Text(text = stringResource(id = R.string.home_overview_to_home_details))
                }
            }
        }

        composable(Route.HOME_DETAILS) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = stringResource(id = R.string.home_details_title),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}