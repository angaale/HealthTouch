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
import com.golenyaeva.healthtouch.screen.onboardingscreen.OnboardingScreen
import com.golenyaeva.healthtouch.screen.onboardingscreen.OnboardingUIModel
import com.golenyaeva.healthtouch.ui.theme.HealthTouchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealthTouchTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    OnboardingScreen(
                        state = OnboardingUIModel(
                            imageRes = R.drawable.ic_onboarding_1,
                            title = R.string.onboarding_screen_1_title,
                            description = R.string.onboarding_screen_1_description,
                            currentPage = 0,
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