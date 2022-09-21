package com.sschmitz.samplenav.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sschmitz.samplenav.R
import com.sschmitz.samplenav.ui.Route
import com.sschmitz.samplenav.ui.ext.switchTabs
import kotlinx.coroutines.launch

fun NavGraphBuilder.settingsGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Route.SETTINGS_OVERVIEW,
        route = Route.SETTINGS_ROOT
    ) {
        composable(Route.SETTINGS_OVERVIEW) {
            val context = LocalContext.current
            val scope = rememberCoroutineScope()

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = stringResource(id = R.string.settings_overview_title),
                    style = MaterialTheme.typography.headlineMedium
                )
                Button(onClick = { navController.navigate(Route.SETTINGS_DETAILS) } ) {
                    Text(text = stringResource(id = R.string.settings_overview_to_settings_details))
                }
                Button(onClick = { navController.switchTabs(Route.HOME_DETAILS) }) {
                    Text(text = stringResource(id = R.string.settings_overview_to_home_details))
                }
            }
        }

        composable(Route.SETTINGS_DETAILS) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = stringResource(id = R.string.settings_details_title),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}
