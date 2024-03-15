package com.bytebusters.android.mpsystem.screens.tools

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bytebusters.android.mpsystem.R
import com.bytebusters.android.mpsystem.screens.tools.views.CreateItemCard
import com.bytebusters.android.mpsystem.ui.bottom_navigation.BottomNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MosaicTools(
    navController: NavHostController,
) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val lazyListState: LazyListState = rememberLazyListState()

    val modifierRow = Modifier
        .fillMaxWidth()
        .padding(vertical = 5.dp)

    val modifierBox = Modifier

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Панель управления")
                },
            )
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) {
        Column(
            modifier = Modifier.padding(vertical = 70.dp)
        ) {
            Row(
                modifier = modifierRow,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(modifier = modifierBox) {
                    CreateItemCard(
                        title = "Мои товары",
                        idPainterResource = R.drawable.barcode,
                        idResourceDescription = R.string.item_content_desc,
                        onClick = {
                            navController.navigate("list_items_screen")
                        }
                    )
                }
                Box(modifier = modifierBox) {
                    CreateItemCard(
                        title = "Поставки",
                        idPainterResource = R.drawable.truck,
                        idResourceDescription = R.string.truck_content_desc,
                        onClick = {

                        }
                    )
                }
            }
            Row(
                modifier = modifierRow, horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(modifier = modifierBox) {
                    CreateItemCard(
                        title = "Финансы",
                        idPainterResource = R.drawable.credit_card,
                        idResourceDescription = R.string.credit_card_content_desc,
                        onClick = {

                        }
                    )
                }
                Box(modifier = modifierBox) {
                    CreateItemCard(
                        title = "Подрядчики",
                        idPainterResource = R.drawable.contractor,
                        idResourceDescription = R.string.contractor_content_desc,
                        onClick = {

                        }
                    )
                }
            }
        }
    }

}

