package com.insigni.mycity.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyCityViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    fun setPlaceCategoryId(cat : Int) {
        _uiState.value.placeCategoryId = cat;
    }

    fun setPlaceId(pla : Int) {
        _uiState.value.placeId = pla;
    }
}