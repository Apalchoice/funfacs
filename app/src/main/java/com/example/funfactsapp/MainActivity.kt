package com.example.funfactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.funfactsapp.ui.theme.FunfactsappTheme
import com.example.funfactsapp.ui.theme.screens.FunFactsNavigationGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            FunfactsappTheme {
                FunfactApp()

            }
        }
    }

    @Composable
    fun FunfactApp() {
        FunFactsNavigationGraph()
    }
}

