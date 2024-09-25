package kr.suwon.chanho.data.usecase.token

import kr.suwon.chanho.data.UserDataStore
import kr.suwon.chanho.domain.usecase.token.GetTokenUseCase
import javax.inject.Inject

internal class GetTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
) : GetTokenUseCase {
    override suspend fun invoke(): String? {
        return userDataStore.getToken()
    }
}