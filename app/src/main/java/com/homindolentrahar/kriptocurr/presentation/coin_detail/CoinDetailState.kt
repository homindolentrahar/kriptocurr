package com.homindolentrahar.kriptocurr.presentation.coin_detail

import com.homindolentrahar.kriptocurr.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = "",
)
