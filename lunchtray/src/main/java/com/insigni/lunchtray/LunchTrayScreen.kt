package com.insigni.lunchtray

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.insigni.lunchtray.datasource.DataSource
import com.insigni.lunchtray.ui.AccompanimentMenuScreen
import com.insigni.lunchtray.ui.CheckoutScreen
import com.insigni.lunchtray.ui.EntreeMenuScreen
import com.insigni.lunchtray.ui.OrderViewModel
import com.insigni.lunchtray.ui.SideDishMenuScreen
import com.insigni.lunchtray.ui.StartOrderScreen

enum class LunchTrayScreen(@StringRes val title: Int) {
    StartOrder(title = com.insigni.lunchtray.R.string.app_name),
    EntreeMenu(title = com.insigni.lunchtray.R.string.choose_entree),
    SideDishMenu(title = com.insigni.lunchtray.R.string.choose_side_dish),
    AccompanimentMenu(title = com.insigni.lunchtray.R.string.choose_accompaniment),
    Checkout(title = com.insigni.lunchtray.R.string.order_checkout),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayAppBar(
    currentScreen: LunchTrayScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                TextButton(onClick = navigateUp) {
                    Text(
                        text = "<-"
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayApp(
    viewModel: OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = LunchTrayScreen.valueOf(
        backStackEntry?.destination?.route ?: LunchTrayScreen.StartOrder.name
    )

    Scaffold(
        topBar = {
            LunchTrayAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                currentScreen = currentScreen,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            navController = navController,
            startDestination = LunchTrayScreen.StartOrder.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = LunchTrayScreen.StartOrder.name) {
                StartOrderScreen(
                    onStartOrderButtonClicked = {
                        navController.navigate(LunchTrayScreen.EntreeMenu.name)
                    },
                )
            }
            composable(route = LunchTrayScreen.EntreeMenu.name) {
                EntreeMenuScreen(
                    DataSource.entreeMenuItems,
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(
                            viewModel = viewModel,
                            navController = navController,
                        )
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.SideDishMenu.name)
                    },
                    onSelectionChanged = { viewModel.updateEntree(it) },
                )
            }
            composable(route = LunchTrayScreen.SideDishMenu.name) {
                SideDishMenuScreen(options = DataSource.sideDishMenuItems,
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(
                            viewModel = viewModel,
                            navController = navController,
                        )
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.AccompanimentMenu.name)
                    },
                    onSelectionChanged = { viewModel.updateSideDish(it) })
            }
            composable(route = LunchTrayScreen.AccompanimentMenu.name) {
                //AccompanimentMenuScreen
                AccompanimentMenuScreen(
                    options = DataSource.accompanimentMenuItems,
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(
                            viewModel = viewModel,
                            navController = navController,
                        )
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.Checkout.name)
                    },
                    onSelectionChanged = { viewModel.updateAccompaniment(it) }
                )
            }
            composable(route = LunchTrayScreen.Checkout.name) {
                //CheckoutScreen
                CheckoutScreen(
                    orderUiState = uiState,
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(
                            viewModel = viewModel,
                            navController = navController,
                        )
                    },
                    onNextButtonClicked = {
                        cancelOrderAndNavigateToStart(
                            viewModel = viewModel,
                            navController = navController,
                        )
                    },
                )
            }
        }
    }
}

private fun cancelOrderAndNavigateToStart(
    viewModel: OrderViewModel,
    navController: NavHostController
) {
    viewModel.resetOrder()
    navController.popBackStack(LunchTrayScreen.StartOrder.name, inclusive = false)
}