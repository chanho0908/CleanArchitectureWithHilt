package kr.suwon.chanho.presentation.main.setting

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kr.suwon.chanho.presentation.component.ProfileImage
import kr.suwon.chanho.presentation.login.LoginActivity
import kr.suwon.chanho.presentation.theme.ConnectedTheme
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun SettingScreen(viewModel: SettingViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val state = viewModel.collectAsState().value
    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is SettingSideEffect.Toast ->
                Toast.makeText(context, sideEffect.message, Toast.LENGTH_SHORT).show()

            is SettingSideEffect.NavigateToLoginActivity -> {
                context.startActivity(Intent(context, LoginActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                }
                )
            }
        }
    }
    SettingScreen(
        userName = state.userName,
        profileImageUrl = state.profileImageUrl,
        onNameChangeClick = { viewModel.onNameChangeClick() },
        onProfileClick = { viewModel.onProfileClick() },
        onLogoutClick = { viewModel.onLogoutClick() }
    )
}

@Composable
private fun SettingScreen(
    userName: String = "안드딱다구리",
    profileImageUrl: String?,
    onNameChangeClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onLogoutClick: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Box {
            ProfileImage(
                modifier = Modifier.size(150.dp),
                profileImageUrl = profileImageUrl
            )

            IconButton(
                onClick = onProfileClick,
                modifier = Modifier.align(Alignment.BottomEnd)
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = CircleShape
                        )
                        .background(color = Color.White, shape = CircleShape)
                ) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(20.dp),
                        imageVector = Icons.Outlined.Settings,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                    )
                }
            }
        }

        Text(
            text = userName,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(top = 8.dp)
                .clickable(onClick = onNameChangeClick)
        )

        Button(
            modifier = Modifier.padding(top = 16.dp),
            onClick = onLogoutClick
        ) {
            Text("로그아웃")
        }
    }
}

@Preview
@Composable
private fun SettingScreenPreview() {
    ConnectedTheme {
        Surface {
            SettingScreen(profileImageUrl = null)
        }
    }
}