package com.golenyaeva.healthtouch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.golenyaeva.coreui.theme.HealthTouchTheme
import com.golenyaeva.healthtouch.presentation.screen.home.HomeScreen
import com.golenyaeva.healthtouch.presentation.screen.home.HomeViewModel
import com.golenyaeva.healthtouch.presentation.screen.home.model.HomeUiModel
import com.golenyaeva.healthtouch.presentation.screen.splashscreen.SplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            HealthTouchTheme {
                Surface {
                    NavHost(navController = navController, startDestination = "splash") {
                        composable("splash") {
                            SplashScreen(navController = navController)
                        }

                        composable("main") {
                            val viewModel: HomeViewModel = hiltViewModel<HomeViewModel>()
                            val state: HomeUiModel = viewModel.uiState.collectAsState().value
                            HomeScreen(
                                state = state,
                                navController = navController,
                                dispatch = viewModel::handleIntent
                            )
                        }
                    }
                }
            }
        }
    }
}
