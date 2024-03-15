package com.bytebusters.android.mpsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bytebusters.android.mpsystem.ui.bottom_navigation.MainScreen
import com.bytebusters.android.mpsystem.ui.theme.MpsystemTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MpsystemTheme {
                MainScreen()
            }
        }
    }
}
