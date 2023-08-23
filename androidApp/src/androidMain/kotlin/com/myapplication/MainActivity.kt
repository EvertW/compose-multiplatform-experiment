package com.myapplication

import MainView
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.core.view.WindowCompat
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import di.DependencyInjector
import org.kodein.di.DIAware

class MainActivity : AppCompatActivity(), DIAware {
    override val di = DependencyInjector

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            BottomSheetNavigator {
                MainView()
            }
        }
    }

}