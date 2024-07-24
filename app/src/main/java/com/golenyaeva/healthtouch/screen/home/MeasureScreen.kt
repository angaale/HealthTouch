package com.golenyaeva.healthtouch.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.golenyaeva.healthtouch.R
import com.golenyaeva.healthtouch.ui.theme.White

@Composable
fun MeasureScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement . spacedBy (64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            color = White,
            fontWeight = FontWeight(400),
            text = stringResource(
                id = R.string.measure_screen_bpm
            )
        )
        MeasureScreenView()
        PercentBarView()
    }

}

@Preview
@Composable
fun MeasureScreenPreview() {
    MeasureScreen()
}
