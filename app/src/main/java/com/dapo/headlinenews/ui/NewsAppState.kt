package com.dapo.headlinenews.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberNewsAppState(
    navController: NavHostController = rememberNavController()
): NewsAppState {
  return   remember(navController) {
      NewsAppState(navController)
  }
}

@Stable
class NewsAppState(
    val navController: NavHostController
) {

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination


}