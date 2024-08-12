package com.golenyaeva.healthtouch.presentation.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.golenyaeva.coreui.kit.OutlinedTextFieldView
import com.golenyaeva.coreui.kit.button.ButtonView
import com.golenyaeva.coreui.kit.button.ButtonViewUiModel
import com.golenyaeva.coreui.theme.White
import com.golenyaeva.healthtouch.R
import com.golenyaeva.healthtouch.domain.UserModel

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    state: ProfileUiModel,
) {
    Box(
        modifier = modifier
            .background(color = White)
            .fillMaxSize(),
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            painter = painterResource(id = R.drawable.profile_background),
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
        )
        ButtonView(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 24.dp)
                .padding(bottom = 42.dp),
            state = ButtonViewUiModel(
                textButtonRes = com.golenyaeva.core_ui.R.string.save,
                isLoading = false,
                style = ButtonViewUiModel.Style.PRIMARY
            )
        )
        Column(
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            UserImage(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextFieldView(
                value = state.userModel.lastName,
                labelRes = R.string.profile_screen_last_name_label,
                supportingTextRes = R.string.profile_screen_last_name_supporting,
            )
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextFieldView(
                value = state.userModel.firstName,
                labelRes = R.string.profile_screen_name_label,
                supportingTextRes = R.string.profile_screen_name_supporting,
            )
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextFieldView(
                value = state.userModel.height.toString(),
                labelRes = R.string.profile_screen_height_label,
                supportingTextRes = R.string.profile_screen_height_supporting,
            )
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextFieldView(
                value = state.userModel.weight.toString(),
                labelRes = R.string.profile_screen_weight_label,
                supportingTextRes = R.string.profile_screen_weight_supporting,
            )
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() = ProfileScreen(
    state = ProfileUiModel(
        userModel = UserModel(
            firstName = "Евгений",
            lastName = "Онегин",
            image = "image",
            height = 100,
            weight = 100,
        )
    )
)