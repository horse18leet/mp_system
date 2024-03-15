package com.bytebusters.android.mpsystem.screens.auth.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bytebusters.android.mpsystem.screens.auth.LoginViewModel

@Composable
fun ProfileView(
    navController: NavHostController,
    onLogout: () -> Unit,
    firstName: String,
    secondName: String,
    onFirstNameChange: (String) -> Unit,
    onSecondNameChange: (String) -> Unit
    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = firstName,
            onValueChange = onFirstNameChange,
            label = { Text("Имя") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = secondName,
            onValueChange = onSecondNameChange,
            label = { Text("Фамилия") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            onLogout()
            navController.navigate("login_screen")
        }) {
            Text("Выйти")
        }
    }
}