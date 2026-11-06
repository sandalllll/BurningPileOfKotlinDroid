package com.insigni.artspaceapp2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.insigni.artspaceapp2.GalleryViewModel
import com.insigni.artspaceapp2.R
import com.insigni.artspaceapp2.data.allArtworks
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GalleryScreen(galleryViewModel: GalleryViewModel = viewModel())
{
    val layoutDirection = LocalLayoutDirection.current
    Column(
        modifier = Modifier.fillMaxSize().statusBarsPadding().padding(
            start = WindowInsets.safeDrawing.asPaddingValues().calculateStartPadding(layoutDirection),
            end = WindowInsets.safeDrawing.asPaddingValues().calculateEndPadding(layoutDirection),
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val galleryUiState by galleryViewModel.uiState.collectAsState()
        Image(
            painter = painterResource(galleryUiState.paintingId),
            contentDescription = stringResource(galleryUiState.paintingNameId),
            modifier = Modifier.height(320.dp)
        )
        Card() {
            Column (horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(galleryUiState.paintingNameId))
                Text(text = stringResource(galleryUiState.authorId) + " (" + galleryUiState.year + ")")
            }
        }
        Row() {
            Button(
                onClick = { galleryViewModel.prevArtwork() },
                modifier = Modifier.width(160.dp)
            ) {
                Text(text = stringResource(R.string.previous))
            }
            Button(
                onClick = { galleryViewModel.nextArtwork() },
                modifier = Modifier.width(160.dp)
            ) {
                Text(text = stringResource(R.string.next))
            }
        }
    }
}