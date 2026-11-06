package com.insigni.artspaceapp2

import androidx.lifecycle.ViewModel
import com.insigni.artspaceapp2.data.allArtworks
import com.insigni.artspaceapp2.model.Artwork
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GalleryViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(allArtworks[0])
    val uiState: StateFlow<Artwork> = _uiState.asStateFlow()
    private var currentArtwork = 0
    fun nextArtwork() {
        currentArtwork = (currentArtwork + 1) % allArtworks.size
        _uiState.value = allArtworks[currentArtwork]
    }
    fun prevArtwork() {
        currentArtwork = (currentArtwork + allArtworks.size + 1) % allArtworks.size
        _uiState.value = allArtworks[currentArtwork]
    }
}