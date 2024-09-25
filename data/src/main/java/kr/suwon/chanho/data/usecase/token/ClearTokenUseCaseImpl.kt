package kr.suwon.chanho.data.usecase.token

import kr.suwon.chanho.data.UserDataStore
import kr.suwon.chanho.domain.usecase.token.ClearTokenUseCase
import javax.inject.Inject

internal class ClearTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
) : ClearTokenUseCase {
    override suspend fun invoke() :Result<Unit> = kotlin.runCatching{
        userDataStore.clear()
    }
}