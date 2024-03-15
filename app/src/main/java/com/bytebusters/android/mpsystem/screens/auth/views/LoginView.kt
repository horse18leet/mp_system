package com.bytebusters.android.mpsystem.screens.auth.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bytebusters.android.mpsystem.screens.auth.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    loginViewModel: LoginViewModel,
) {
    val textForEmailField = remember { mutableStateOf("gluhih2003@yandex.ru") }
    val textForPasswordField = remember { mutableStateOf("@8acJMQKc") }
    val loginClicked = remember { mutableStateOf(false) }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Авторизация", fontSize = 25.sp,
        )
        Spacer(modifier = Modifier.height(40.dp))
        TextField(
            value = textForEmailField.value,
            onValueChange = { newText -> textForEmailField.value = newText },
            shape = MaterialTheme.shapes.medium,
            textStyle = TextStyle(fontSize = 10.sp),
            placeholder = { Text("Электронная почта") },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )
        Spacer(modifier = Modifier.height(15.dp))
        TextField(
//            modifier = Modifier.size(width = 525.dp, height = 95.dp),
            value = textForPasswordField.value,
            onValueChange = { newText -> textForPasswordField.value = newText },
            shape = MaterialTheme.shapes.medium,
            textStyle = TextStyle(fontSize = 10.sp),
            placeholder = { Text("Пароль") },

            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )

        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                loginClicked.value = true
                loginViewModel.login(textForEmailField, textForPasswordField)
                navController.navigate("dashboard_screen")
            }
        ) {
            Text(text = "Войти")
        }
    }
}
