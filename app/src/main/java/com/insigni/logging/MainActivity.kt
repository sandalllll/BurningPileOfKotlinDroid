package com.insigni.logging

import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import timber.log.Timber
import timber.log.Timber.Forest.plant

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val actv = findViewById<AutoCompleteTextView>(R.id.log_text);
        findViewById<Button>(R.id.button_log)
            .setOnClickListener {
                Log.println(
                    Log.VERBOSE,
                    "From AutoCompleteTextView",
                    actv.getText().toString()
                );
            };
        plant(Timber.DebugTree());
        findViewById<Button>(R.id.button_timber)
            .setOnClickListener {
                Timber.log(
                    2,
                    actv.getText().toString()
                )
            };
    }
}