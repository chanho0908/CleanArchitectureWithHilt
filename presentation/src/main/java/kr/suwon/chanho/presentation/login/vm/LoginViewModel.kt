package kr.suwon.chanho.presentation.login.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.suwon.chanho.domain.usecase.login.LoginUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel(){

    fun onLoginClick(){
        val id = ""
        val password = ""

        viewModelScope.launch {
            loginUseCase.login(id, password)
        }
    }
}