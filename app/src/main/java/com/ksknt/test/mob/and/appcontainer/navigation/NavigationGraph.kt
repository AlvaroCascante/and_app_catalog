package com.ksknt.test.mob.and.appcontainer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ksknt.test.mob.and.appcontainer.AppsCatalog
import com.ksknt.test.mob.and.appcontainer.MainDestination
import com.ksknt.test.mob.and.appcontainer.diceRoller.DiceRollerApp
import com.ksknt.test.mob.and.appcontainer.diceRoller.DiceRollerDestination

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = MainDestination.route,
        modifier = modifier
    ) {
        composable(route = MainDestination.route) {
            AppsCatalog(navController = navController)
        }
        composable(route = DiceRollerDestination.route) {
            DiceRollerApp(navController = navController)
        }
    }
}