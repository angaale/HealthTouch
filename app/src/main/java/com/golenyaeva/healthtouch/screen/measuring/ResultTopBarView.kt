package com.golenyaeva.healthtouch.screen.measuring

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.golenyaeva.healthtouch.R
import com.golenyaeva.coreui.theme.LightGreen

@Composable
fun ResultTopBarView(
    modifier: Modifier = Modifier,
    date: String,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    bottomStart = 24.dp,
                    bottomEnd = 24.dp
                )
            )
            .background(color = LightGreen),
    ) {
        Row(
            modifier = Modifier.padding(
                start = 24.dp,
                end = 24.dp,
                top = 60.dp,
                bottom = 24.dp,
            )
        ) {
            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Text(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    text = stringResource(
                        id = R.string.result_screen_title,
                    )
                )
                Text(
                    text = date,
                    fontSize = 12.sp,
                    modifier = modifier.padding(top = 8.dp),
                    fontWeight = FontWeight(400),
                )
            }
        }
    }
}

@Preview
@Composable
fun ResultTopBarPreview() = ResultTopBarView(
    date = "28.04.2024"
)
