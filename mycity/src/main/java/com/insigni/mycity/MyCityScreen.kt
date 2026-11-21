package com.insigni.mycity

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.insigni.mycity.ui.MyCityViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.insigni.mycity.data.placeCategories
import com.insigni.mycity.data.places
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.items

enum class MyCityScreen(@StringRes val title: Int) {
    Start(title = com.insigni.mycity.R.string.app_name),
    Categories(title = com.insigni.mycity.R.string.categories),
    Places(title = com.insigni.mycity.R.string.places),
}

@Composable
fun MyCityApp(
    modifier: Modifier = Modifier,
    viewModel: MyCityViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
) {
    val uiState by viewModel.uiState.collectAsState()
    NavHost(
        navController = navController,
        startDestination = MyCityScreen.Start.name,
        modifier = modifier,
    ) {
        composable(route = MyCityScreen.Start.name) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(64.dp))
                LazyColumn(
                    modifier = modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(placeCategories) { item ->
                        Row() {
                            Image(
                                painter = painterResource(item.placeCategoryIconId),
                                contentDescription = "",
                                modifier = Modifier.height(64.dp)
                            )
                            Button(
                                onClick = {
                                    viewModel.setPlaceCategoryId(item.id)
                                    navController.navigate(MyCityScreen.Categories.name)
                                },
                            ) {
                                Text(stringResource(item.placeCategoryNameId))
                            }
                        }
                    }
                }
            }
        }
        composable(route = MyCityScreen.Categories.name) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(64.dp))
                Button(
                    onClick = {navController.navigateUp()},
                ) {
                    Text(stringResource(R.string.go_back))
                }
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(top = 32.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    itemsIndexed(
                        items = places[uiState.placeCategoryId],
                    ) { index, item ->
                        Row() {
                            Image(
                                painter = painterResource(item.placeIconId),
                                contentDescription = stringResource(item.placeNameId),
                                modifier = Modifier.height(64.dp)
                            )
                            Button(
                                onClick = {
                                    viewModel.setPlaceId(index)
                                    navController.navigate(MyCityScreen.Places.name)
                                },
                            ) {
                                Text(stringResource(item.placeNameId))
                            }
                        }
                    }
                }
            }
/*            PlacesScreen(places[uiState.placeCategoryId], )*/
        }
        composable(route = MyCityScreen.Places.name) {
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    modifier = Modifier.padding(16.dp),
                    onClick = {navController.navigateUp()},
                ) {
                    Text(stringResource(R.string.go_back))
                }
                Image(
                    painter = painterResource(places[uiState.placeCategoryId][uiState.placeId].placeIconId),
                    contentDescription = stringResource(places[uiState.placeCategoryId][uiState.placeId].placeNameId),
                    modifier = Modifier.height(64.dp)
                )
                Text(
                    text = stringResource(places[uiState.placeCategoryId][uiState.placeId].placeNameId),
                    fontSize = 32.sp,
                )
                Text(stringResource(places[uiState.placeCategoryId][uiState.placeId].placeDescriptionId))
            }
        }
    }
}