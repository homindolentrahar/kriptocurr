package com.homindolentrahar.kriptocurr.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.homindolentrahar.kriptocurr.data.remote.dto.TeamMember
import com.homindolentrahar.kriptocurr.presentation.ui.theme.Black
import com.homindolentrahar.kriptocurr.presentation.ui.theme.Dark
import com.homindolentrahar.kriptocurr.presentation.ui.theme.White

@Composable
fun TeamListItem(
    teamMember: TeamMember,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = teamMember.name,
            style = MaterialTheme.typography.h4,
            color = White,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = teamMember.position,
            style = MaterialTheme.typography.body2,
            color = Color.LightGray,
        )
    }
}