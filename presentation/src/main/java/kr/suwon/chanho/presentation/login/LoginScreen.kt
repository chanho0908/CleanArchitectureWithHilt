package kr.suwon.chanho.presentation.login

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kr.suwon.chanho.presentation.component.CustomButton
import kr.suwon.chanho.presentation.component.CustomTextField
import kr.suwon.chanho.presentation.login.vm.LoginSideEffect
import kr.suwon.chanho.presentation.login.vm.LoginViewModel
import kr.suwon.chanho.presentation.main.MainActivity
import kr.suwon.chanho.presentation.theme.ConnectedTheme
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun LoginScreen(
    // NavHost 위치(현재 화면)에 따라 생명주기를 관리해주는 역할
    viewModel: LoginViewModel = hiltViewModel(),
    onNavigateToSignUpScreen: () -> Unit
) {
    val state = viewModel.collectAsState().value
    val context = LocalContext.current

    viewModel.collectSideEffect { se ->
        when (se) {
            is LoginSideEffect.Toast -> {
                Toast.makeText(context, se.message, Toast.LENGTH_SHORT).show()
            }
            LoginSideEffect.NavigateToMain -> {
                context.startActivity(Intent(context, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                )
            }
        }
    }

    LoginScreen(
        id = state.id,
        password = state.password,
        onIdChange = viewModel::onIdChange,
        onPasswordChange = viewModel::onPasswordChange,
        onNavigateToSignUpScreen = onNavigateToSignUpScreen,
        onLoginClick = viewModel::onLoginClick
    )
}

@Composable
private fun LoginScreen(
    id: String,
    password: String,
    onIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onNavigateToSignUpScreen: () -> Unit,
    onLoginClick: () -> Unit = {}
) {
    Surface {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 48.dp)
            ) {
                Text(
                    text = "Connected",
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = "Your favorite social network",
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(top = 24.dp)
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Log In",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(top = 36.dp)
            )
            Text(
                text = "ID",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(top = 16.dp)
            )
            CustomTextField(
                value = id,
                onValueChange = onIdChange,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            )

            Text(
                text = "Password",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(top = 16.dp)
            )
            CustomTextField(
                value = password,
                onValueChange = onPasswordChange,
                visualTransformation = PasswordVisualTransformation(), // password format
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            )
            CustomButton(
                text = "로그인",
                onClick = onLoginClick,
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 24.dp)
                    .clickable(onClick = onNavigateToSignUpScreen)
            ) {
                Text("아직 계정이 없으신가요? ")
                Text("회원가입을 진행해주세요!", color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    ConnectedTheme {
        LoginScreen(
            id = "",
            password = "",
            onIdChange = {},
            onPasswordChange = {},
            onNavigateToSignUpScreen = {}
        )
    }
}