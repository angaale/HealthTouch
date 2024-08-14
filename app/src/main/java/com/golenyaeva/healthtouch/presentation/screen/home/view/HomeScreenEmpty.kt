package com.golenyaeva.healthtouch.presentation.screen.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.golenyaeva.coreui.theme.TextDisable
import com.golenyaeva.coreui.theme.White
import com.golenyaeva.healthtouch.R
import com.golenyaeva.healthtouch.domain.UserModel
import com.golenyaeva.healthtouch.presentation.screen.home.model.HomeUiModel
import drawable.NavigationBarView

@Composable
fun HomeScreenNoItems(
    modifier: Modifier = Modifier,
    state: HomeUiModel.NoItems,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = White),
    ) {
        HomeTopBar(
            state = state.user
        )
        NavigationBarView(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(R.string.home_screen_empty_title),
                fontSize = 12.sp,
                color = TextDisable,
                fontWeight = FontWeight(400),
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenNoItemsPreview() {
    HomeScreenNoItems(
        state = HomeUiModel.NoItems(
            user = UserModel(
                firstName = "Евгений",
                lastName = "Онегин",
                image = "image",
                height = 100,
                weight = 100,
            ),
        )
    )
}
