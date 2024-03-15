package com.bytebusters.android.mpsystem.screens.tools.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CreateItemCard(title: String, idPainterResource: Int, idResourceDescription: Int, onClick: () -> Unit) {
    val cardModifier = Modifier
        .width(180.dp)
        .height(80.dp)
        .padding(vertical = 5.dp, horizontal = 5.dp)

    Card(
        modifier = cardModifier,
        elevation = 10.dp,
        backgroundColor = Color.White,
        onClick = onClick
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(horizontal = 10.dp),
                painter = painterResource(id = idPainterResource),
                contentDescription = stringResource(id = idResourceDescription)
            )
            Text(text = title, fontSize = 3.5.em)
        }

    }
}