package kr.suwon.chanho.domain.usecase.main.setting

interface UpdateMyNameUseCase {
    suspend operator fun invoke(name: String?): Result<Unit>
}