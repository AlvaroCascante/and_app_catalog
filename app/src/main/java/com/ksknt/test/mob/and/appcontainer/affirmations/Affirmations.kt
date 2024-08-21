package com.ksknt.test.mob.and.appcontainer.affirmations

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ksknt.test.mob.and.appcontainer.R
import com.ksknt.test.mob.and.appcontainer.navigation.CustomAppBar
import com.ksknt.test.mob.and.appcontainer.navigation.NavigationDestination

object AffirmationsAppDestination: NavigationDestination {
    override val route = "affirmations"
    override val title = R.string.affirmations_screen
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AffirmationsApp(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomAppBar(
                currentScreen = AffirmationsAppDestination,
                showBackButton = true,
                onBackClick = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        AffirmationsAppContent(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun AffirmationsAppContent(
    modifier: Modifier = Modifier
) {

    val layoutDirection = LocalLayoutDirection.current

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues().calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues().calculateEndPadding(layoutDirection),
            ),
    ) {
        AffirmationList(
            itemsList = AffirmationDatasource().loadAffirmations(),
        )
    }
}

@Composable
fun AffirmationList(
    itemsList: List<Affirmation>,
    modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(itemsList) { item ->
            AffirmationCard(
                item = item,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun AffirmationCard(
    item: Affirmation,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(item.imageResourceId),
                contentDescription = stringResource(item.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = LocalContext.current.getString(item.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AffirmationsAppContentPreview() {
    AffirmationsAppContent(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AffirmationListPreview() {
    AffirmationList(
        AffirmationDatasource().loadAffirmations()
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AffirmationCardPreview() {
    AffirmationCard(
        Affirmation(R.string.affirmation1, R.drawable.image1)
    )
}