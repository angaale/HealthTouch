package com.golenyaeva.healthtouch.presentation.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.golenyaeva.healthtouch.R

@Composable
fun UserImage(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .wrapContentSize()
    ) {
        Image(
            modifier = Modifier,
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = null,
        )
        Image(
            modifier = Modifier.align(Alignment.BottomEnd),
            painter = painterResource(id = R.drawable.ic_pencil),
            contentDescription = null,
        )
    }
}

@Preview
@Composable
fun UserImagePreview() = UserImage()
