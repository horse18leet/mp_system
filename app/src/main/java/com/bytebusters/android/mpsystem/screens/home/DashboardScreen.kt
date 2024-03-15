package com.bytebusters.android.mpsystem.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import co.yml.charts.axis.AxisData
import co.yml.charts.axis.DataCategoryOptions
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.ui.barchart.BarChart
import co.yml.charts.ui.barchart.models.BarChartData
import co.yml.charts.ui.barchart.models.BarChartType
import co.yml.charts.ui.barchart.models.BarStyle
import com.bytebusters.android.mpsystem.application.HomeApplication
import com.bytebusters.android.mpsystem.screens.home.views.TodaySummaryScreen
import com.bytebusters.android.mpsystem.sharedprefs.SessionManager
import com.bytebusters.android.mpsystem.ui.bottom_navigation.BottomNavigation

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DashboardScreen(navController: NavHostController) {

    val sessionManager = SessionManager(HomeApplication.getAppContext())

    val userData = mutableStateOf(sessionManager.fetchUser())

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Домашняя страница")
                },
            )
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )   {
        if (userData.value != null) {
            Column(
                modifier = Modifier.padding(vertical = 75.dp)
            ) {
                Row {
                    //BarchartWithSolidBars()
                }
                Row {
                    TodaySummaryScreen(
                        ordersToday = 10,
                        dirtyIncome = 15004,
                        cleanIncome = 7864,
                        expensesToday = 23
                    )
                }
            }
        }
    }

}

@Composable
private fun BarchartWithSolidBars() {
    val maxRange = 7
    val barData =
        DataUtils.getBarChartData(9, maxRange, BarChartType.HORIZONTAL, DataCategoryOptions())
    val yStepSize = 5

    val xAxisData = AxisData.Builder()
        .axisStepSize(30.dp)
        .steps(barData.size - 1)
        .bottomPadding(40.dp)
        .axisLabelAngle(20f)
        .startDrawPadding(48.dp)
        .labelData { index -> barData[index].label }
        .build()

    val yAxisData = AxisData.Builder()
        .steps(yStepSize)
        .labelAndAxisLinePadding(20.dp)
        .axisOffset(20.dp)
        .labelData { index -> (index * (maxRange / yStepSize)).toString() }
        .build()

    val barChartData = BarChartData(
        chartData = barData,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        barStyle = BarStyle(
            paddingBetweenBars = 20.dp,
            barWidth = 25.dp
        ),
        showYAxis = true,
        showXAxis = true,
        horizontalExtraSpace = 10.dp,
    )
    BarChart(modifier = Modifier.height(350.dp), barChartData = barChartData)
}


