package com.golenyaeva.healthtouch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.golenyaeva.coreui.theme.HealthTouchTheme
import com.golenyaeva.healthtouch.presentation.screen.main.MainScreen
import com.golenyaeva.healthtouch.presentation.screen.main.MainViewModel
import com.golenyaeva.healthtouch.presentation.screen.main.model.Intent
import com.golenyaeva.healthtouch.presentation.screen.main.model.MainTabRoute
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
                            val viewModel: MainViewModel = hiltViewModel()
                            val state = viewModel.uiState.collectAsState().value

                            val callback: OnBackPressedCallback =
                                object : OnBackPressedCallback(true) {
                                    override fun handleOnBackPressed() {
                                        viewModel.handleIntent(Intent.OnTabClicked(MainTabRoute.Home))
                                    }
                                }
                            onBackPressedDispatcher.addCallback(this@MainActivity, callback)

                            MainScreen(
                                state = state,
                                dispatch = viewModel::handleIntent,
                            )
                        }
                    }
                }
            }
        }
    }
}
