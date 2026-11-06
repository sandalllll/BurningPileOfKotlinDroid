package com.insigni.desertclicker.ui

import com.insigni.desertclicker.data.allDesserts

class DesertClickerUiState (
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertImageId: Int = allDesserts[0].imageId,
)