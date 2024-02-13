package com.myapplication

import MainView
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import util.ApplicationContextProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ApplicationContextProvider.init(applicationContext)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MainView(this)
        }
    }
}