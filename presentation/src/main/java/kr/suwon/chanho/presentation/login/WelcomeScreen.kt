package kr.suwon.chanho.presentation.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.suwon.chanho.presentation.component.CustomButton
import kr.suwon.chanho.presentation.component.CustomHeader
import kr.suwon.chanho.presentation.theme.ConnectedTheme

@Composable
fun WelcomeScreen(
    onNavigateToLoginScreen: () -> Unit
) {
    Surface{
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier.fillMaxSize()
        ) {
            CustomHeader()
            CustomButton(
                text = "로그인",
                onClick = onNavigateToLoginScreen,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .padding(24.dp)
                    .align(Alignment.BottomCenter)
                    .height(48.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeScreenPreview() {
    ConnectedTheme{
        WelcomeScreen(
            onNavigateToLoginScreen = {}
        )
    }
}