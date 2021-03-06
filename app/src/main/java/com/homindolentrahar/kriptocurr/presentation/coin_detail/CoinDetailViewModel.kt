package com.homindolentrahar.kriptocurr.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.homindolentrahar.kriptocurr.common.Constants
import com.homindolentrahar.kriptocurr.common.Resource
import com.homindolentrahar.kriptocurr.domain.usecase.coins.GetCoinDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoinById(coinId)
        }
    }

    private fun getCoinById(coinId: String) {
        getCoinDetailUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = CoinDetailState(error = result.message ?: "Unexpected error!")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}