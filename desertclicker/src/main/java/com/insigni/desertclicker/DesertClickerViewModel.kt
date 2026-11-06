package com.insigni.desertclicker

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.insigni.desertclicker.data.allDesserts
import com.insigni.desertclicker.model.Dessert
import com.insigni.desertclicker.ui.DesertClickerUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

private fun determineDessertToShow(
    dessertsSold: Int
): Dessert {
    var dessertToShow = allDesserts.first()
    for (dessert in allDesserts) {
        if (dessertsSold >= dessert.startProductionAmount) {
            dessertToShow = dessert
        } else {
            // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
            // you'll start producing more expensive desserts as determined by startProductionAmount
            // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
            // than the amount sold.
            break
        }
    }

    return dessertToShow
}

class DesertClickerViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DesertClickerUiState())
    val uiState: StateFlow<DesertClickerUiState> = _uiState.asStateFlow()
    private var currentDessertPrice: Int = allDesserts[0].price
    fun DesertClick()
    {
        val dessertToShow = determineDessertToShow(_uiState.value.dessertsSold)

        _uiState.value = DesertClickerUiState(
            revenue = _uiState.value.revenue + currentDessertPrice,
            dessertsSold = _uiState.value.dessertsSold + 1,
            currentDessertImageId = dessertToShow.imageId
        )
        currentDessertPrice = dessertToShow.price
    }
}
