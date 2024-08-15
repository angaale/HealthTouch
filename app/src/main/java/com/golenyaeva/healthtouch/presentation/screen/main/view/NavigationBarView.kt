package com.golenyaeva.healthtouch.presentation.screen.main.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.golenyaeva.core_ui.R
import com.golenyaeva.coreui.theme.White
import com.golenyaeva.healthtouch.presentation.screen.main.model.MainTabRoute

@Composable
fun NavigationBarView(
    modifier: Modifier = Modifier,
    onTabClicked: (MainTabRoute) -> Unit = {},
) {
    Box(
        modifier
            .height(84.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter,
    ) {
        Row(
            modifier = Modifier
                .padding(top = 6.dp)
                .height(78.dp)
                .fillMaxWidth()
                .background(White)
        ) {
            Image(
                modifier = Modifier
                    .padding(
                        start = 28.dp,
                        top = 12.dp,
                    )
                    .clickable {
                        onTabClicked.invoke(MainTabRoute.Home)
                    },
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = null
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier
                    .padding(
                        end = 28.dp,
                        top = 12.dp,
                    )
                    .clickable {
                        onTabClicked.invoke(MainTabRoute.Chat)
                    },
                painter = painterResource(id = R.drawable.ic_chat),
                contentDescription = null
            )
        }
        Image(
            modifier = Modifier
                .clickable {
                    onTabClicked.invoke(MainTabRoute.Measure)
                },
            painter = painterResource(id = R.drawable.ic_measure),
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun NavigationBarPreview() = NavigationBarView()
