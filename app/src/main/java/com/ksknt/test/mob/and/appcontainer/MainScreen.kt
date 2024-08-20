package com.ksknt.test.mob.and.appcontainer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ksknt.test.mob.and.appcontainer.navigation.AppNavHost
import com.ksknt.test.mob.and.appcontainer.navigation.NavigationDestination

object MainDestination: NavigationDestination {
    override val route = "main"
    override val title = R.string.main_screen
}

/** Load the Navigation and the AppBar
 *  NavHost would navigate to the main page of the app
 * */
@Composable
fun ApplicationsCatalog(navController: NavHostController = rememberNavController()) {
    AppNavHost(navController = navController)
}

@Composable
fun AppsCatalog(
    appsList: List<AppModel> = APPS,
    navController: NavHostController,
    modifier: Modifier = Modifier) {

    var appItem by remember { mutableStateOf(APPS[0]) }

    Column (modifier = modifier.fillMaxWidth()) {
        LazyRow(modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            items(appsList) { app ->
                AppCard(app, navController, onClick = { appItem = app })
            }
        }
        AppCardDetail(app = appItem)
    }
}

@Composable
fun AppCard(
    app: AppModel,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(modifier = modifier
        .padding(8.dp)
        .size(200.dp)
        .clickable { onClick() }
    ) {
        Column(modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()) {
            Text(
                text = app.name,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = app.description,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis)
            Spacer(modifier = Modifier.weight(1F))
            Button(
                enabled = app.destinationURL?.isNotBlank() ?: false,
                onClick = { app.destinationURL?.let { navController.navigate(it) } },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ){
                Text(text = "GO")
            }
        }
    }
}

@Composable
fun AppCardDetail(app: AppModel, modifier: Modifier = Modifier) {
    Card(modifier = modifier
        .padding(8.dp)
        .fillMaxWidth()
    ) {
        LazyColumn(modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()) {
            items(app.functionalities) { app ->
                Text(text = "* " + app.name + ": " + app.description)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppsAppsCatalogPreview() {
    AppsCatalog(APPS, rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun AppCardPreview() {
    AppCard(APPS[0], rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun AppCardDetailPreview() {
    AppCardDetail(APPS[0])
}