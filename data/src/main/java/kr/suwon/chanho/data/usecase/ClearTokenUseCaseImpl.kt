package kr.suwon.chanho.data.usecase

import kr.suwon.chanho.data.UserDataStore
import kr.suwon.chanho.domain.usecase.login.ClearTokenUseCase
import javax.inject.Inject

class ClearTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
) : ClearTokenUseCase {
    override suspend fun invoke(){
        userDataStore.clear()
    }
}