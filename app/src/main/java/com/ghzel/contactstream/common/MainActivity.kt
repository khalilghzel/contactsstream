package com.ghzel.contactstream.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ghzel.contactstream.routes.NAV_HOME
import com.ghzel.contactstream.ui.home.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenStarted {
            setContent {
                val navController = rememberNavController()
                NavGraph(navController = navController, NAV_HOME)
            }
        }
      installSplashScreen()
    }
}

@Composable
fun NavGraph(navController: NavHostController, start: String) {

    NavHost(
        navController = navController,
        startDestination = start
    )
    {
        composable(route = NAV_HOME) {
            HomeScreen(navController)
        }
    }
}
