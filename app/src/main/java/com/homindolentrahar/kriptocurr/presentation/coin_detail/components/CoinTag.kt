package com.homindolentrahar.kriptocurr.presentation.coin_detail.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.homindolentrahar.kriptocurr.presentation.ui.theme.Dark
import com.homindolentrahar.kriptocurr.presentation.ui.theme.White

@Composable
fun CoinTag(
    tag: String
) {
    Card(
        modifier = Modifier.padding(4.dp),
        backgroundColor = Dark,
        shape = RoundedCornerShape(
            corner = CornerSize(16.dp),
        ),
    ) {
        Text(
            text = tag,
            style = MaterialTheme.typography.body2,
            color = White,
            fontWeight = FontWeight.SemiBold,
        )
    }
}