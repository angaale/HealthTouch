package com.golenyaeva.healthtouch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.golenyaeva.healthtouch.domain.UserModel
import com.golenyaeva.healthtouch.screen.homescreen.HomeScreen
import com.golenyaeva.healthtouch.screen.homescreen.HomeUiModel
import com.golenyaeva.healthtouch.screen.homescreen.MainTabViewUiModel
import com.golenyaeva.healthtouch.screen.homescreen.MeasuringBpmHrvUiModel
import com.golenyaeva.healthtouch.screen.homescreen.MeasuringUiModel
import com.golenyaeva.healthtouch.ui.theme.HealthTouchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealthTouchTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        state = HomeUiModel(
                            user = UserModel(
                                image = "",
                                firstName = "Евгений",
                                lastName = "Онегин",
                            ),
                            tabs = listOf(
                                MainTabViewUiModel.MeasuringTab(
                                    titleRes = R.string.main_tab_title_measure,
                                    subtitle = "29.11.2024",
                                    buttonTextRes = R.string.main_tab_button_measure,
                                    measuring = MeasuringBpmHrvUiModel(
                                        bpm = MeasuringUiModel.BPM(86),
                                        hrv = MeasuringUiModel.HRV(164),
                                    ),
                                ),
                                MainTabViewUiModel.MeasuringTab(
                                    titleRes = R.string.main_tab_title_measure,
                                    subtitle = "29.11.2024",
                                    buttonTextRes = R.string.main_tab_button_measure,
                                    measuring = MeasuringBpmHrvUiModel(
                                        bpm = MeasuringUiModel.BPM(86),
                                        hrv = MeasuringUiModel.HRV(164),
                                    ),
                                ),
                            )
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HealthTouchTheme {
        Greeting("Android")
    }
}