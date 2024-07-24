package com.golenyaeva.healthtouch.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.golenyaeva.healthtouch.R
import com.golenyaeva.healthtouch.ui.theme.Black
import com.golenyaeva.healthtouch.ui.theme.White

@Composable
fun MeasureScreenView(

) {
    Box(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    bottomEnd = 40.dp,
                    bottomStart = 40.dp,
                    topEnd = 40.dp,
                    topStart = 40.dp,
                )
            )
            .wrapContentSize()
            .background(color = Black)
            .alpha(0.5f)
            .padding(
                start = 10.dp,
                top = 10.dp,
                end = 10.dp,
                bottom = 10.dp,
            )
    ) {
        Text(
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = White,
            fontWeight = FontWeight(300),
            text = stringResource(
                id = R.string.measure_screen_advice
            )
        )
    }
}

@Preview
@Composable
fun MeasureScreenViewPreview(){
    MeasureScreenView()
}
