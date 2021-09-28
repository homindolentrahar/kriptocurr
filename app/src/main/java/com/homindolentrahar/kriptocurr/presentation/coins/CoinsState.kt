package com.homindolentrahar.kriptocurr.presentation.coins

import com.homindolentrahar.kriptocurr.domain.model.Coin

data class CoinsState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = "",
)
