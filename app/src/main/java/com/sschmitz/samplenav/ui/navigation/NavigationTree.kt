package com.sschmitz.samplenav.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.sschmitz.samplenav.R
import com.sschmitz.samplenav.ui.Route

enum class NavigationTree(@StringRes val displayName: Int, val image: ImageVector, val route: String){
    HOME(R.string.bottom_nav_home, Icons.Default.Home, Route.HOME_ROOT),
    SETTINGS(R.string.bottom_nav_settings, Icons.Default.Settings, Route.SETTINGS_ROOT)
}