package com.juhyeon.composemvi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.juhyeon.composemvi.feature.home.HomeRoute
import com.juhyeon.composemvi.feature.splash.SplashRoute
import com.juhyeon.composemvi.shared.navigation.Home
import com.juhyeon.composemvi.shared.navigation.Splash

@Composable
fun MainNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Splash
    ) {
        composable<Splash> {
            SplashRoute(
                navController = navController
            )
        }

        composable<Home> {
            val homeNavController = rememberNavController()
            HomeRoute(
                navController = homeNavController
            )
        }
    }
}