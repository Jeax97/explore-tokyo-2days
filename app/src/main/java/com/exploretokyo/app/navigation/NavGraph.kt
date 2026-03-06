package com.exploretokyo.app.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.exploretokyo.app.ui.screens.*

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Day : Screen("day/{dayNumber}") {
        fun createRoute(dayNumber: Int) = "day/$dayNumber"
    }
    object ActivityDetail : Screen("activity/{activityId}") {
        fun createRoute(activityId: String) = "activity/$activityId"
    }
    object Map : Screen("map")
}

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        enterTransition = {
            fadeIn(animationSpec = tween(300)) +
                slideInHorizontally(animationSpec = tween(300)) { it / 4 }
        },
        exitTransition = {
            fadeOut(animationSpec = tween(300)) +
                slideOutHorizontally(animationSpec = tween(300)) { -it / 4 }
        },
        popEnterTransition = {
            fadeIn(animationSpec = tween(300)) +
                slideInHorizontally(animationSpec = tween(300)) { -it / 4 }
        },
        popExitTransition = {
            fadeOut(animationSpec = tween(300)) +
                slideOutHorizontally(animationSpec = tween(300)) { it / 4 }
        }
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(
                onSplashFinished = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(
                onDayClick = { dayNumber ->
                    navController.navigate(Screen.Day.createRoute(dayNumber))
                }
            )
        }

        composable(
            route = Screen.Day.route,
            arguments = listOf(navArgument("dayNumber") { type = NavType.IntType })
        ) { backStackEntry ->
            val dayNumber = backStackEntry.arguments?.getInt("dayNumber") ?: 1
            DayScreen(
                dayNumber = dayNumber,
                onActivityClick = { activityId ->
                    navController.navigate(Screen.ActivityDetail.createRoute(activityId))
                }
            )
        }

        composable(
            route = Screen.ActivityDetail.route,
            arguments = listOf(navArgument("activityId") { type = NavType.StringType })
        ) { backStackEntry ->
            val activityId = backStackEntry.arguments?.getString("activityId") ?: ""
            ActivityDetailScreen(
                activityId = activityId,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Map.route) {
            MapScreen(
                onActivityClick = { activityId ->
                    navController.navigate(Screen.ActivityDetail.createRoute(activityId))
                }
            )
        }
    }
}
