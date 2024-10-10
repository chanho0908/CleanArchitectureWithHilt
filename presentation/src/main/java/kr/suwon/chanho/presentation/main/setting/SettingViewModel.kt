package kr.suwon.chanho.presentation.main.setting

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kr.suwon.chanho.domain.usecase.main.setting.GetMyUserUseCase
import kr.suwon.chanho.domain.usecase.token.ClearTokenUseCase
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val clearTokenUseCase: ClearTokenUseCase,
    private val getMyUserUseCase: GetMyUserUseCase
) : ViewModel(), ContainerHost<SettingState, SettingSideEffect> {

    override val container: Container<SettingState, SettingSideEffect> = container(
        initialState = SettingState(),
        buildSettings = {
            this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                intent { postSideEffect(SettingSideEffect.Toast(throwable.message.orEmpty())) }
            }
        }
    )

    init {
        load()
    }

    private fun load() = intent{
        val user = getMyUserUseCase().getOrThrow()
        reduce {
            state.copy(
                userName = user.username,
                profileImageUrl = user.profileImageUrl
            )
        }
    }

    fun onLogoutClick() = intent {
        clearTokenUseCase().getOrThrow()
        postSideEffect(SettingSideEffect.NavigateToLoginActivity())
    }

    fun onProfileClick() = intent {

    }

    fun onNameChangeClick() = intent {

    }

}

@Immutable
data class SettingState(
    val userName: String = "",
    val profileImageUrl: String? = null
)

sealed interface SettingSideEffect {
    class Toast(val message: String) : SettingSideEffect
    class NavigateToLoginActivity : SettingSideEffect
}