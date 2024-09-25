package kr.suwon.chanho.data.usecase.token

import kr.suwon.chanho.data.UserDataStore
import kr.suwon.chanho.domain.usecase.token.SetTokenUseCase
import javax.inject.Inject

internal class SetTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
) : SetTokenUseCase {
    override suspend fun invoke(token: String) {
        userDataStore.setToken(token)
    }

}