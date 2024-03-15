package com.bytebusters.android.mpsystem.ui.bottom_navigation

import com.bytebusters.android.mpsystem.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String) {
    data object Screen1: BottomItem("Dashboard", R.drawable.ic_home_black_24dp, "dashboard_screen")
    data object Screen2: BottomItem("Tools", R.drawable.baseline_auto_awesome_mosaic_24, "mosaic_tools_screen")
    data object Screen3: BottomItem("Add", R.drawable.baseline_add_circle_outline_24, "add_item_screen")
    data object Screen4: BottomItem("Profile", R.drawable.baseline_account_circle_24, "login_screen")
}