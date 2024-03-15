package com.bytebusters.android.mpsystem.screens.items.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Preview
@Composable
fun ItemView() {
    Column {
        Row {
            Card(
                modifier = Modifier.size(width = 160.dp, height = 220.dp),
            ) {
                Column (verticalArrangement = Arrangement.SpaceBetween) {
                    Box(modifier = Modifier.padding(5.dp).fillMaxWidth().weight(1f)) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AsyncImage(
                                model = "https://basket-14.wbbasket.ru/vol2108/part210877/210877739/images/big/1.webp",
                                contentDescription = "This is an example image",
                                modifier = Modifier.fillMaxSize(),
                            )
                        }
                    }

                    Box(modifier = Modifier.padding(2.dp)) {
                        Column() {
                            Divider(color = Color.White, thickness = 1.dp)

                            Column(modifier = Modifier.padding(5.dp)) {
                                Text(text = "Категория", fontSize = 10.sp)
                                Text(text = "Название товара", fontSize = 13.sp)
                            }

                        }
                    }





                }



            }
        }
    }

}
