package kr.suwon.chanho.domain.usecase.token

interface ClearTokenUseCase {
    suspend operator fun invoke(): Result<Unit>
}