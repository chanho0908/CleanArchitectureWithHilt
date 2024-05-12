package kr.suwon.chanho.presentation.main.setting

import android.net.Uri
import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kr.suwon.chanho.domain.usecase.main.setting.GetMyProfileUseCase
import kr.suwon.chanho.domain.usecase.main.setting.SetProfileImageUseCase
import kr.suwon.chanho.domain.usecase.main.setting.UpdateMyNameUseCase
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
    private val getMyProfileUseCase: GetMyProfileUseCase,
    private val updateMyNameUseCase: UpdateMyNameUseCase,
    private val setProfileImageUseCase: SetProfileImageUseCase
): ViewModel(), ContainerHost<SettingState, SettingSideEffect> {

    override val container: Container<SettingState, SettingSideEffect> =
        container(
            initialState = SettingState(),
            buildSettings = {
                this.exceptionHandler = CoroutineExceptionHandler{ _, throwable ->
                    intent{ postSideEffect(SettingSideEffect.Toast(throwable.message.orEmpty())) }
                }
            }
        )

    init {
        load()
    }

    private fun load() = intent{
        val user = getMyProfileUseCase().getOrThrow()
        reduce {
            state.copy(
                profileImageUrl = user.profileImageUrl,
                username = user.username
            )
        }

    }

    fun onLogoutClick() = intent{
        clearTokenUseCase().getOrThrow()
        postSideEffect(SettingSideEffect.NavigateToLoginActivity)
    }

    fun onUsernameChange(name: String) = intent{
        updateMyNameUseCase(name).getOrThrow()
        load()
    }

    fun onImageChange(uri: Uri?) {

    }
}

@Immutable
data class SettingState(
    val profileImageUrl: String? = null,
    val username: String = "",
)

sealed interface SettingSideEffect {
    class Toast(val message: String) : SettingSideEffect

    object NavigateToLoginActivity : SettingSideEffect
}