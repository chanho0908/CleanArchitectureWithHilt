package kr.suwon.chanho.data.usecase

import kr.suwon.chanho.data.UserDataStore
import kr.suwon.chanho.domain.usecase.login.SetTokenUseCase
import javax.inject.Inject

class SetTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
): SetTokenUseCase {
    override suspend fun invoke(token: String) {
        userDataStore.setToken(token)
    }
}