package com.homindolentrahar.kriptocurr.domain.usecase.coins

import com.homindolentrahar.kriptocurr.common.Resource
import com.homindolentrahar.kriptocurr.domain.model.Coin
import com.homindolentrahar.kriptocurr.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        emit(Resource.Loading())

        emit(repository.getCoins())
    }
}