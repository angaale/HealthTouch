package com.golenyaeva.healthtouch.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.golenyaeva.healthtouch.ui.theme.BlackTransparent20
import com.golenyaeva.healthtouch.ui.theme.White

@Composable
fun PercentBarView(
    modifier: Modifier = Modifier,
    percent: Float,
) {
    Row(modifier = modifier) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topEnd = 24.dp,
                        bottomEnd = 24.dp
                    )
                )
                .fillMaxWidth(percent)
                .background(color = White)
                .height(6.dp),
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = BlackTransparent20)
                .height(6.dp),
        )
    }
}

@Preview
@Composable
fun PercentBarViewPreview() = PercentBarView(percent = 0.5f)
