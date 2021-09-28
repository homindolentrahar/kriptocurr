package com.homindolentrahar.kriptocurr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.homindolentrahar.kriptocurr.presentation.Screen
import com.homindolentrahar.kriptocurr.presentation.coin_detail.CoinDetailScreen
import com.homindolentrahar.kriptocurr.presentation.coins.CoinsScreen
import com.homindolentrahar.kriptocurr.presentation.ui.theme.KriptocurrTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KriptocurrTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinsScreen.route,
                    ) {
                        composable(
                            route = Screen.CoinsScreen.route,
                        ) {
                            CoinsScreen(navController = navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}",
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}