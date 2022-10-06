package com.sschmitz.samplenav.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sschmitz.samplenav.R
import com.sschmitz.samplenav.ui.Route
import com.sschmitz.samplenav.ui.ext.switchTabs
import com.sschmitz.samplenav.ui.settings.SettingsDetails
import com.sschmitz.samplenav.ui.settings.SettingsHome
import kotlinx.coroutines.launch

fun NavGraphBuilder.settingsGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Route.SETTINGS_OVERVIEW,
        route = Route.SETTINGS_ROOT
    ) {
        composable(Route.SETTINGS_OVERVIEW) {
            SettingsHome(
                toSettingsDetails = { navController.navigate(Route.SETTINGS_DETAILS) },
                toHomeDetailsBroken = { navController.navigate(Route.HOME_DETAILS) },
                toHomeDetailsFixed = { navController.switchTabs(Route.HOME_DETAILS) },
                modifier = Modifier.fillMaxSize().padding(16.dp)
            )
        }

        composable(Route.SETTINGS_DETAILS) {
            SettingsDetails(
                modifier = Modifier.fillMaxSize().padding(16.dp)
            )
        }
    }
}
