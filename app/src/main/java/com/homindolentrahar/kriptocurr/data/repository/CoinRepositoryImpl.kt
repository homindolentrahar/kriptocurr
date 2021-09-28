package com.homindolentrahar.kriptocurr.data.repository

import com.homindolentrahar.kriptocurr.common.Resource
import com.homindolentrahar.kriptocurr.data.remote.CoinPaprikaApi
import com.homindolentrahar.kriptocurr.data.remote.dto.toCoin
import com.homindolentrahar.kriptocurr.data.remote.dto.toCoinDetail
import com.homindolentrahar.kriptocurr.domain.model.Coin
import com.homindolentrahar.kriptocurr.domain.model.CoinDetail
import com.homindolentrahar.kriptocurr.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi,
) : CoinRepository {
    override suspend fun getCoins(): Resource<List<Coin>> {
        return try {
            val coins = api.getCoins().map { dto -> dto.toCoin() }

            Resource.Success<List<Coin>>(coins)
        } catch (e: HttpException) {
            Resource.Error<List<Coin>>(e.localizedMessage ?: "Unexpected Error")
        } catch (e: IOException) {
            Resource.Error<List<Coin>>("Couldn't react server!")
        }
    }

    override suspend fun getCoinById(coinId: String): Resource<CoinDetail> {
        return try {
            val coinDetail = api.getCoinById(coinId).toCoinDetail()

            return Resource.Success<CoinDetail>(coinDetail)
        } catch (e: HttpException) {
            Resource.Error<CoinDetail>(e.localizedMessage ?: "Unexpected Error")
        } catch (e: IOException) {
            Resource.Error<CoinDetail>("Couldn't react server!")
        }
    }
}