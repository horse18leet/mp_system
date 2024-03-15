package com.bytebusters.android.mpsystem.screens.items

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bytebusters.android.mpsystem.screens.items.views.ItemView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListItemsScreen(
    navController: NavHostController
) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val lazyListState: LazyListState = rememberLazyListState()

    var expanded by remember { mutableStateOf(false) }


    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                ),
                title = {
                    Text(
                        "Список товаров",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("mosaic_tools_screen") }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            expanded = true
                        }

                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "image",
                            tint = Color.Black,
                        )
                    }

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(text = { Text("Создать товар") }, onClick = {
                            navController.navigate("add_item_screen")
                        })
                    }


                },
                scrollBehavior = scrollBehavior
            )
        },
    ) {
        LazyColumn(
            state = lazyListState,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 70.dp)
        ) {
            item {
                rowImage()
            }
            item {
                rowImage()
            }
            item {
                rowImage()
            }
            item {
                rowImage()
            }
            item {
                rowImage()
            }

        }
    }


}

@Composable
fun rowImage() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(vertical = 5.dp)
    ) {
        Box(modifier = Modifier.weight(1f)) {
            ItemView()
        }
        Box() {
            ItemView()
        }

    }
}

