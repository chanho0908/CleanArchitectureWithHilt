package kr.suwon.chanho.presentation.splash.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kr.suwon.chanho.domain.usecase.login.GetTokenUseCase
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getTokenUseCase: GetTokenUseCase
): ViewModel() {
    private val _token = MutableStateFlow<String?>("")
    val token = _token.asStateFlow()
    init {
        viewModelScope.launch {
            _token.value = getTokenUseCase()
        }
    }
}