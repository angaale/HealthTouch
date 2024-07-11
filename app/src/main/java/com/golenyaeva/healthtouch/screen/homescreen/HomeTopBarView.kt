package com.golenyaeva.healthtouch.screen.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.golenyaeva.healthtouch.R
import com.golenyaeva.healthtouch.domain.UserModel
import com.golenyaeva.healthtouch.ui.theme.LightGreen

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
    state: UserModel,
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
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.ic_user_empty),
                contentDescription = ""
            )
            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Text(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    text = stringResource(
                        id = R.string.home_screen_greeting,
                        state.firstName
                    )
                )
                Text(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    modifier = modifier.padding(top = 8.dp),
                    text = stringResource(
                        id = R.string.home_screen_question,
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeTopBarPreview() {
    HomeTopBar(
        state = UserModel(
            firstName = "Евгений",
            lastName = "Онегин",
            image = "Image",
        )
    )
}