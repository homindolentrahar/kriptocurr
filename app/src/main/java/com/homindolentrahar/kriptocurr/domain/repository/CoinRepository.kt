package com.homindolentrahar.kriptocurr.domain.repository

import com.homindolentrahar.kriptocurr.common.Resource
import com.homindolentrahar.kriptocurr.domain.model.Coin
import com.homindolentrahar.kriptocurr.domain.model.CoinDetail

interface CoinRepository {
    suspend fun getCoins(): Resource<List<Coin>>
    suspend fun getCoinById(coinId: String): Resource<CoinDetail>
}