package com.insigni.attributes

import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        val actv = findViewById<AutoCompleteTextView>(R.id.text_displayer);
        findViewById<Button>(R.id.but_text_black)
            .setOnClickListener {
                actv.setTextColor(0xff000000.toInt());
            };
        findViewById<Button>(R.id.but_text_red)
            .setOnClickListener {
                actv.setTextColor(0xffff0000.toInt());
            };
        findViewById<Button>(R.id.but_size_8)
            .setOnClickListener {
                actv.setTextSize(8.0f);
            };
        findViewById<Button>(R.id.but_size_24)
            .setOnClickListener {
                actv.setTextSize(24.0f);
            };
        findViewById<Button>(R.id.but_back_yellow)
            .setOnClickListener {
                actv.setBackgroundColor(0xffffff00.toInt());
            };
        findViewById<Button>(R.id.but_back_white)
            .setOnClickListener {
                actv.setBackgroundColor(0xffffffff.toInt());
            };
    }
}