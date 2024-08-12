package com.golenyaeva.healthtouch.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.golenyaeva.healthtouch.R
import com.golenyaeva.coreui.theme.BlackTransparent20
import com.golenyaeva.coreui.theme.White

@Composable
fun CardText(
    modifier: Modifier = Modifier,
    text: String,
    textSize: Int,
) {
    Box(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    bottomEnd = 40.dp,
                    bottomStart = 40.dp,
                    topEnd = 40.dp,
                    topStart = 40.dp,
                )
            )
            .wrapContentSize()
            .background(color = BlackTransparent20)
            .padding(10.dp)
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = textSize.sp,
            color = White,
            fontWeight = FontWeight(300),
        )
    }
}

@Preview
@Composable
fun CardTextViewPreview() = CardText(
    text = stringResource(id = R.string.measure_screen_advice),
    textSize = 20,
)
