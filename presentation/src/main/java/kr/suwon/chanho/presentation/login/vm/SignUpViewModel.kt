package kr.suwon.chanho.presentation.login.vm

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kr.suwon.chanho.domain.usecase.login.SignUpUseCase
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@OptIn(OrbitExperimental::class)
@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
): ViewModel(),
    ContainerHost<SignUpState, SignUpSideEffect> {
    override val container: Container<SignUpState, SignUpSideEffect> = container(
        initialState = SignUpState(),
        buildSettings = {
            this.exceptionHandler = CoroutineExceptionHandler{ _, throwable ->
                intent { postSideEffect(SignUpSideEffect.Toast(throwable.message ?: "Unknown Error")) }
            }
        }
    )

    fun onIdChange(id: String) = blockingIntent {
        reduce { state.copy(id = id) }
    }

    fun onUsernameChange(username: String) = blockingIntent {
        reduce { state.copy(username = username) }
    }

    fun onPassword1Change(password1: String) = blockingIntent {
        reduce { state.copy(password1 = password1) }
    }

    fun onPassword2Change(password2: String) = blockingIntent {
        reduce { state.copy(password2 = password2) }
    }

    fun onSignUpClick() = intent {
        if (state.password1 != state.password2) {
            postSideEffect(SignUpSideEffect.Toast("비밀번호가 일치하지 않습니다."))
            return@intent
        }
        val isSignUpSuccess = signUpUseCase(
            id = state.id,
            username = state.username,
            password = state.password1
        ).getOrThrow()

        if (isSignUpSuccess){
            postSideEffect(SignUpSideEffect.Toast("회원 가입 성공 ~!"))
            postSideEffect(SignUpSideEffect.NavigateToLoginScreen)
        }
    }
}

@Immutable
data class SignUpState(
    val id: String = "",
    val username: String = "",
    val password1: String = "",
    val password2: String = ""
)

sealed class SignUpSideEffect{
    data class Toast(val message: String): SignUpSideEffect()

    object NavigateToLoginScreen: SignUpSideEffect()
}