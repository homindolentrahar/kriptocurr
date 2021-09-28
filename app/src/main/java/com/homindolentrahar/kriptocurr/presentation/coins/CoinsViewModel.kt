package com.homindolentrahar.kriptocurr.presentation.coins

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.homindolentrahar.kriptocurr.common.Resource
import com.homindolentrahar.kriptocurr.domain.usecase.coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinsState())
    val state: State<CoinsState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = CoinsState(error = result.message ?: "Unexpected error!")
                }
                is Resource.Loading -> {
                    _state.value = CoinsState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinsState(coins = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}