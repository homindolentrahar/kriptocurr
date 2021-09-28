package com.homindolentrahar.kriptocurr.presentation.coin_detail

import android.view.RoundedCorner
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowRow
import com.homindolentrahar.kriptocurr.presentation.Screen
import com.homindolentrahar.kriptocurr.presentation.coin_detail.components.CoinTag
import com.homindolentrahar.kriptocurr.presentation.coin_detail.components.TeamListItem
import com.homindolentrahar.kriptocurr.presentation.ui.theme.Dark
import com.homindolentrahar.kriptocurr.presentation.ui.theme.Green
import com.homindolentrahar.kriptocurr.presentation.ui.theme.Red
import com.homindolentrahar.kriptocurr.presentation.ui.theme.White

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
    ) {
        state.coin?.let { coinDetail ->
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Start,
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
                                    text = coinDetail.rank.toString(),
                                    style = MaterialTheme.typography.subtitle2,
                                )
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = coinDetail.symbol,
                                style = MaterialTheme.typography.h4,
                            )
                        }
                        Card(
                            modifier = Modifier
                                .padding(8.dp),
                            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
                            backgroundColor = if (coinDetail.isActive) Green else Red,
                        ) {
                            Text(
                                text = if (coinDetail.isActive) "Active" else "Inactive",
                                style = MaterialTheme.typography.h6,
                                color = White,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = coinDetail.description,
                        style = MaterialTheme.typography.body2,
                        color = Color.LightGray,
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h6,
                        color = Color.LightGray,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    FlowRow(
                        mainAxisSpacing = 16.dp,
                        crossAxisSpacing = 8.dp,
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        coinDetail.tags.forEach { tag ->
                            CoinTag(tag = tag)
                        }
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = "Team Members",
                        style = MaterialTheme.typography.h6,
                        color = Color.LightGray,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
                items(coinDetail.team) { member ->
                    TeamListItem(
                        teamMember = member,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                    Divider()
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                style = MaterialTheme.typography.h6.copy(
                    color = Red,
                ),
                textAlign = TextAlign.Center,
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}