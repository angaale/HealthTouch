package com.golenyaeva.healthtouch.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.golenyaeva.healthtouch.domain.CardActivitiesModel

@Composable
fun CardsActivities(
    modifier: Modifier = Modifier,
    state: CardActivitiesModel,
) {
    Box(
        modifier = modifier
            .size(150.dp)
    ) {
        Image(
            modifier = Modifier.wrapContentSize(),
            painter = painterResource(id = state.image),
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
        )
        Text(
            modifier = Modifier
                .padding(12.dp),
            text = stringResource(id = state.titleRes),
            fontSize = 14.sp,
            fontWeight = FontWeight(500),
        )
    }
}

@Preview
@Composable
fun CardsActivitiesPreview() {
    CardsActivities(
        state = CardActivitiesModel.Excitement()
    )
}
