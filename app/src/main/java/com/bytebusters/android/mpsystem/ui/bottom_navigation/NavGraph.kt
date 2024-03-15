package com.bytebusters.android.mpsystem.ui.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bytebusters.android.mpsystem.screens.home.DashboardScreen
import com.bytebusters.android.mpsystem.screens.auth.LoginScreen
import com.bytebusters.android.mpsystem.screens.auth.LoginViewModel
import com.bytebusters.android.mpsystem.screens.items.AddItemScreen
import com.bytebusters.android.mpsystem.screens.items.ListItemsScreen
import com.bytebusters.android.mpsystem.screens.tools.MosaicTools

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = "dashboard_screen") {
        composable("dashboard_screen") {
            DashboardScreen(navHostController)
        }
//        composable("mosaic_screen") {
//            MosaicScreen()
//        }

        composable("add_item_screen") {
            AddItemScreen()
        }
        composable("mosaic_tools_screen") {
            MosaicTools(navHostController)
        }
        composable("list_items_screen") {
            ListItemsScreen(navHostController)
        }

        composable("add_item_screen") {
            AddItemScreen()
        }
        composable("login_screen") {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(
                navController = navHostController,
                loginViewModel = loginViewModel
            )
        }

    }
}