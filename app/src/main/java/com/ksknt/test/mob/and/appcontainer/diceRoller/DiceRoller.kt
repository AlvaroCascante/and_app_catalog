package com.ksknt.test.mob.and.appcontainer.diceRoller

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ksknt.test.mob.and.appcontainer.R
import com.ksknt.test.mob.and.appcontainer.navigation.CustomAppBar
import com.ksknt.test.mob.and.appcontainer.navigation.NavigationDestination

object DiceRollerDestination: NavigationDestination {
    override val route = "diceRoller"
    override val title = R.string.dice_roller_screen
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiceRollerApp(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomAppBar(
                currentScreen = DiceRollerDestination,
                showBackButton = true,
                onBackClick = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        DiceRollerContent(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun DiceRollerContent(
    modifier: Modifier = Modifier
) {
    var result by remember { mutableIntStateOf(1) }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = getImageResource(result)), contentDescription = result.toString())
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random() }) {
            Text(stringResource(R.string.roll))
        }
    }
}

private fun getImageResource(result: Int): Int {
    return when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DiceRollerAppPreview() {
    DiceRollerApp(
        navController = rememberNavController(),
        modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}