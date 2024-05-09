package kr.suwon.chanho.data.usecase

import kr.suwon.chanho.data.UserDataStore
import kr.suwon.chanho.domain.usecase.login.GetTokenUseCase
import javax.inject.Inject

class GetTokenUseCaseImpl @Inject constructor(
    private val useDataStore: UserDataStore
): GetTokenUseCase{
    override suspend fun invoke(): String? {
        return useDataStore.getToken()
    }
}