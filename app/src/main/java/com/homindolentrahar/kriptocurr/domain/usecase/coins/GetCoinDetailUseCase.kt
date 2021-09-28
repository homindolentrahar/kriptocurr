package com.homindolentrahar.kriptocurr.domain.usecase.coins

import com.homindolentrahar.kriptocurr.common.Resource
import com.homindolentrahar.kriptocurr.domain.model.CoinDetail
import com.homindolentrahar.kriptocurr.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        emit(Resource.Loading())

        emit(repository.getCoinById(coinId))
    }
}