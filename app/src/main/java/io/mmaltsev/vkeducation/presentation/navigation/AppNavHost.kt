package io.mmaltsev.vkeducation.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.mmaltsev.vkeducation.presentation.appdetails.AppDetailsScreen
import io.mmaltsev.vkeducation.presentation.applist.AppListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppListRoute,
    ) {
        composable<AppListRoute> {
            AppListScreen(
                onAppClick = { appId ->
                    navController.navigate(AppDetailsRoute(id = appId))
                },
            )
        }
        composable<AppDetailsRoute> {
            AppDetailsScreen(
                onBackClick = {
                    navController.navigateUp()
                },
                onShowcaseAppClick = {
                    navController.popBackStack(route = AppListRoute, inclusive = false)
                },
            )
        }
    }
}
