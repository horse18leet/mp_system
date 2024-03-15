package com.bytebusters.android.mpsystem.screens.items

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import me.saket.cascade.CascadeDropdownMenu


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AddItemScreen(
) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val lazyListState: LazyListState = rememberLazyListState()

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var firstPrice by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var mpLink by remember { mutableStateOf("") }

    val mContext = LocalContext.current
    var expanded by remember { mutableStateOf(false) }


    var rowPaddingModifier = Modifier
        .padding(vertical = 8.dp)
        .fillMaxWidth()

    var textFieldModifier = Modifier
        .width(330.dp)

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                ),
                title = {
                    Text(
                        "Создание товара",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        //navController.navigate("mosaic_tools_screen")
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            //expanded = true
                        }

                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "image",
                            tint = Color.Black,
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 80.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {

            Row(
                rowPaddingModifier,
                horizontalArrangement = Arrangement.Center
            ) {
                CascadeDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text(text = "1. Item") },
                        children = {
                            DropdownMenuItem(
                                text = { Text(text = "1.1. Sub-Item") },
                                onClick = {
                                    expanded = false
                                    Toast.makeText(mContext, "1.1. Sub-Item", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            )
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "2. Item") },
                        children = {
                            DropdownMenuItem(
                                text = { Text(text = "2.1. Sub-Item") },
                                onClick = {
                                    expanded = false
                                    Toast.makeText(mContext, "2.1. Sub-Item", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            )
                            DropdownMenuItem(
                                text = { Text(text = "2.2. Sub-Item") },
                                children = {
                                    DropdownMenuItem(
                                        text = { Text(text = "2.2.1. Sub-Sub-Item") },
                                        onClick = {
                                            expanded = false
                                            Toast.makeText(
                                                mContext,
                                                "2.2.1. Sub-Sub-Item",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    )
                                }
                            )
                        }
                    )
                }
            }

            //название
            Row(
                rowPaddingModifier,
                horizontalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = title,
                    onValueChange = { if (it.length <= 255) title = it },
                    textFieldModifier,
                    label = { Text("Название *") },
                    maxLines = 2
                )
            }

            //описание
            Row(
                rowPaddingModifier,
                horizontalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = description,
                    onValueChange = { if (it.length <= 1000) description = it },
                    textFieldModifier,
                    label = { Text("Описание") },
                    maxLines = 5
                )
            }

            //закупочная цена
            Row(
                rowPaddingModifier,
                horizontalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = firstPrice,
                    onValueChange = {
                        if (it.length <= 15) firstPrice = it
                    },
                    textFieldModifier,
                    singleLine = true,
                    label = { Text("Закупочная цена *") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    maxLines = 1
                )
            }

            //описание
            Row(
                rowPaddingModifier,
                horizontalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = description,
                    onValueChange = { if (it.length <= 1000) description = it },
                    textFieldModifier,
                    label = { Text("Ссылка (при наличии)") },
                    maxLines = 5
                )
            }

            Row(
                rowPaddingModifier,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {

                }) {
                    Text("Создать")
                }
            }


        }
    }


}

