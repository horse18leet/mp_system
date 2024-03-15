package com.bytebusters.android.mpsystem.screens.home.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

@Preview
@Composable
fun TodaySummaryScreen(
    ordersToday: Int = 10,
    dirtyIncome: Int = 1590,
    cleanIncome: Int = 54000,
    expensesToday: Int = 24
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Column {
                CardReportWithBorder(title = "Заказов", value = ordersToday.toString())
                CardReportWithBorder(title = "Расходы", value = dirtyIncome.toString())
            }
            Column {
                CardReportWithBorder(title = "Доход", value = cleanIncome.toString())
                CardReportWithBorder(title = "Выкуплено", value = expensesToday.toString())
            }
        }
    }
}

@Composable
fun CardReportWithBorder(title: String, value: String) {
    val paddingModifier = Modifier.padding(5.dp)
    Card(
        modifier = paddingModifier.size(width = 140.dp, height = 100.dp),
        elevation = 10.dp,
        backgroundColor = Color.White
    ) {
        Column(modifier = paddingModifier) {
            Text(text = title, modifier = paddingModifier, fontSize = 3.4.em)
            Text(text = value, modifier = paddingModifier, fontSize = 5.em)
        }

    }
}
