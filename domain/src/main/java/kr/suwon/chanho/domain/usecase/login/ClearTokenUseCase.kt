package kr.suwon.chanho.domain.usecase.login

interface ClearTokenUseCase {
    suspend operator fun invoke()
}