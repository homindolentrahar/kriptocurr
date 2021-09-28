package com.homindolentrahar.kriptocurr.presentation.coins.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.homindolentrahar.kriptocurr.domain.model.Coin
import com.homindolentrahar.kriptocurr.presentation.ui.theme.Dark
import com.homindolentrahar.kriptocurr.presentation.ui.theme.Green
import com.homindolentrahar.kriptocurr.presentation.ui.theme.Red

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit,
) {
    Row(
        modifier = Modifier
            .clickable { onItemClick(coin) }
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .border(
                        BorderStroke(1.5.dp, Dark),
                        shape = RoundedCornerShape(5.dp),
                    )
                    .padding(8.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = coin.rank.toString(),
                    style = MaterialTheme.typography.subtitle2,
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.wrapContentHeight(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = coin.symbol,
                    style = MaterialTheme.typography.h4,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = coin.name,
                    style = MaterialTheme.typography.body2,
                    color = Color.LightGray,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = if (coin.isActive) "Active" else "Inactive",
                    style = MaterialTheme.typography.h6.copy(
                        color = if (coin.isActive) Green else Red,
                    )
                )
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = if (coin.isActive) "Active" else "Inactive",
            style = MaterialTheme.typography.h6.copy(
                color = if (coin.isActive) Green else Red,
            )
        )
    }
}