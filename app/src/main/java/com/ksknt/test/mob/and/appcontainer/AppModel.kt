package com.ksknt.test.mob.and.appcontainer

import com.ksknt.test.mob.and.appcontainer.diceRoller.DiceRollerDestination
import com.ksknt.test.mob.and.appcontainer.tipCalculator.TipCalculatorDestination

data class AppModel(
    val name: String,
    val description: String,
    val linkURL: String? = null,
    val destinationURL: String? = null,
    val functionalities: List<AppFunctionalityModel>
) {
}

data class AppFunctionalityModel(
    val name: String,
    val description: String
) {
}

val APPS = listOf(
    AppModel(
        name = "App Catalog",
        description = "App to show catalog applications and its implemented functions",
        functionalities = listOf(
            AppFunctionalityModel(
                name = "Navigation",
                description = "Define a nav graph and destinations to navigate"
            ),
            AppFunctionalityModel(
                name = "App Bar",
                description = "Implement an app bar with a back button"
            )
        )
    ),
    AppModel(
        name = "Dice Roller",
        description = "A simple dice roller app",
        linkURL = "https://developer.android.com/codelabs/basic-android-kotlin-training-create-dice-roller-app-with-button",
        destinationURL = DiceRollerDestination.route,
        functionalities = listOf(
            AppFunctionalityModel(
                name = "Composable Functions",
                description = "Define composable functions"
            ),
            AppFunctionalityModel(
                name = "Drawable Resources",
                description = "Import drawable Resources"
            ),
            AppFunctionalityModel(
                name = "Interactive UI",
                description = "Use the remember composable"
            ),
            AppFunctionalityModel(
                name = "Refresh UI",
                description = "Refresh the UI with the mutableStateOf() function to make an observable"
            )
        )
    ),
    AppModel(
        name = "Tip Calculator",
        description = "A tip calculator app",
        linkURL = "https://github.com/google-developer-training/basic-android-kotlin-compose-training-tip-calculator.git",
        destinationURL = TipCalculatorDestination.route,
        functionalities = listOf(
            AppFunctionalityModel(
                name = "State and MutableState",
                description = "State in an app is any value that can change over time."
            ),
            AppFunctionalityModel(
                name = "Input Text",
                description = "Use recomposition on input texts and leading icons. "
            ),
            AppFunctionalityModel(
                name = "State Hoisting",
                description = "State hoisting is a pattern of moving state to its caller to make a component stateless."
            ),
            AppFunctionalityModel(
                name = "Switch",
                description = "Switch component."
            ),
            AppFunctionalityModel(
                name = "Testing",
                description = "Local and instrumentation tests."
            )
        )
    )
)