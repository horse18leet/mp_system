package com.bytebusters.android.mpsystem.screens.auth

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.bytebusters.android.mpsystem.application.HomeApplication
import com.bytebusters.android.mpsystem.screens.auth.views.LoginView
import com.bytebusters.android.mpsystem.screens.auth.views.ProfileView
import com.bytebusters.android.mpsystem.sharedprefs.SessionManager


@SuppressLint("UnrememberedMutableState")
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    loginViewModel: LoginViewModel,
) {

    var isLoggedIn: MutableState<Boolean> = mutableStateOf(loginViewModel.checkIsLoggedIn())

    var sessionManager = SessionManager(HomeApplication.getAppContext())

    val userData = sessionManager.fetchUser()

    if (!isLoggedIn.value) {
        LoginView(navController = navController, loginViewModel = loginViewModel)
    }
    else{
        ProfileView(
            navController = navController,
            onLogout = {
                       loginViewModel.logout()
                       },
            firstName = userData!!.firstName!!,
            secondName = userData.secondName!!,
            onFirstNameChange = { "" },
            onSecondNameChange = { "" }
        )
    }




}








