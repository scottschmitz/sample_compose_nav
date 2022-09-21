package com.sschmitz.samplenav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sschmitz.samplenav.ui.BottomNav
import com.sschmitz.samplenav.ui.Route
import com.sschmitz.samplenav.ui.navigation.homeGraph
import com.sschmitz.samplenav.ui.navigation.settingsGraph
import com.sschmitz.samplenav.ui.theme.SamplenavTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SamplenavTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    Scaffold(
                        bottomBar = { BottomNav(navController) },
                        content = { innerPadding ->
                            NavHost(
                                navController = navController,
                                startDestination = Route.HOME_ROOT,
                                modifier = Modifier.padding(innerPadding)
                            ) {
                                homeGraph(navController)
                                settingsGraph(navController)
                            }
                        }
                    )
                }
            }
        }
    }
}
