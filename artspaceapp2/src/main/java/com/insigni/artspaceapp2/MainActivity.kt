package com.insigni.artspaceapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.insigni.artspaceapp2.ui.theme.ArtSpaceApp2Theme
import com.insigni.artspaceapp2.ui.GalleryScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceApp2Theme(){
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    GalleryScreen()
                }
            }
        }
    }
}