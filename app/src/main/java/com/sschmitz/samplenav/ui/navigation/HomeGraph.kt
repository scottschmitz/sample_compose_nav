package com.sschmitz.samplenav.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sschmitz.samplenav.R
import com.sschmitz.samplenav.ui.Route
import com.sschmitz.samplenav.ui.home.HomeDetails
import com.sschmitz.samplenav.ui.home.HomeOverview

fun NavGraphBuilder.homeGraph(navController: NavHostController) {
    navigation(
        startDestination = Route.HOME_OVERVIEW,
        route = Route.HOME_ROOT
    ) {
        composable(Route.HOME_OVERVIEW) {
            HomeOverview(
                toDetails = { navController.navigate(Route.HOME_DETAILS) },
                modifier = Modifier.fillMaxSize().padding(16.dp)
            )
        }

        composable(Route.HOME_DETAILS) {
            HomeDetails(
                modifier = Modifier.fillMaxSize().padding(16.dp)
            )
        }
    }
}
