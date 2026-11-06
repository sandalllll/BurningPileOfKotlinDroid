package com.insigni.activitylifecycle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.insigni.activitylifecycle.ui.theme.ActivityLifecycleTheme

//import androidx.lifecycle.viewmodel.compose.viewModel
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActivityLifecycleTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Hello!"
                    )
                }
            }
        }
        println("Вызывано: onCreate.");
    }

    override fun onStart() {
        super.onStart()
        println("Вызывано: onStart.");
    }

    override fun onResume() {
        super.onResume()
        println("Вызывано: onResume.");
    }

    override fun onPause() {
        super.onPause()
        println("Вызывано: onPause.");
    }

    override fun onStop() {
        super.onStop()
        println("Вызывано: onStop.");
    }

    override fun onRestart() {
        super.onRestart()
        println("Вызывано: onRestart.");
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Вызывано: onDestroy.");
    }
}