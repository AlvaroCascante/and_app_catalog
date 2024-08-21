package com.ksknt.test.mob.and.appcontainer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ksknt.test.mob.and.appcontainer.AppsCatalog
import com.ksknt.test.mob.and.appcontainer.MainDestination
import com.ksknt.test.mob.and.appcontainer.affirmations.AffirmationsApp
import com.ksknt.test.mob.and.appcontainer.affirmations.AffirmationsAppDestination
import com.ksknt.test.mob.and.appcontainer.dessertClicker.DessertClickerApp
import com.ksknt.test.mob.and.appcontainer.dessertClicker.DessertClickerAppDestination
import com.ksknt.test.mob.and.appcontainer.diceRoller.DiceRollerApp
import com.ksknt.test.mob.and.appcontainer.diceRoller.DiceRollerDestination
import com.ksknt.test.mob.and.appcontainer.tipCalculator.TipCalculatorApp
import com.ksknt.test.mob.and.appcontainer.tipCalculator.TipCalculatorDestination
import com.ksknt.test.mob.and.appcontainer.unscramble.UnscrambleApp
import com.ksknt.test.mob.and.appcontainer.unscramble.UnscrambleAppDestination

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
        composable(route = TipCalculatorDestination.route) {
            TipCalculatorApp(navController = navController)
        }
        composable(route = AffirmationsAppDestination.route) {
            AffirmationsApp(navController = navController)
        }
        composable(route = DessertClickerAppDestination.route) {
            DessertClickerApp(navController = navController)
        }
        composable(route = UnscrambleAppDestination.route) {
            UnscrambleApp(navController = navController)
        }
    }
}