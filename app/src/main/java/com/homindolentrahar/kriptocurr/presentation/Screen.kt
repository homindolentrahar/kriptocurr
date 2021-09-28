package com.homindolentrahar.kriptocurr.presentation

sealed class Screen(val route: String) {
    object CoinsScreen : Screen("/coins")
    object CoinDetailScreen : Screen("/coin-detail")
}
