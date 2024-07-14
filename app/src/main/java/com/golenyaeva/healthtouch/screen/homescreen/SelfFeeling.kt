package com.golenyaeva.healthtouch.screen.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.golenyaeva.healthtouch.ui.theme.Primary
import com.golenyaeva.healthtouch.ui.theme.TextPrimary

@Composable
fun SelfFeeling(
    modifier: Modifier = Modifier,
    state: SelfFeelingUiModel,
) {
    Box(
        modifier = modifier
            .height(90.dp)
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    bottomStart = 24.dp,
                    bottomEnd = 24.dp,
                    topEnd = 24.dp,
                    topStart = 24.dp,
                )
            )
            .background(color = state.backgroundColor)
            .padding(12.dp),
    ) {
        Column {
            Text(
                text = stringResource(id = state.title, state.percent),
                fontWeight = FontWeight(500),
                fontSize = 20.sp,
                color = Primary,
            )
            Text(
                text = stringResource(id = state.subtitle),
                fontWeight = FontWeight(400),
                fontSize = 12.sp,
                color = TextPrimary,
                modifier = modifier.padding(top = 8.dp),
            )
        }

    }

}

@Preview
@Composable
fun SelfFeelingBadPreview() = SelfFeeling(
    state = SelfFeelingUiModel.Bad(
        percent = 6
    )
)

@Preview
@Composable
fun SelfFeelingOkayPreview() = SelfFeeling(
    state = SelfFeelingUiModel.Okay(
        percent = 76
    )
)

@Preview
@Composable
fun SelfFeelingGoodPreview() = SelfFeeling(
    state = SelfFeelingUiModel.Good(
        percent = 82
    )
)
