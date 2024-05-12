package kr.suwon.chanho.domain.usecase.main.setting

interface SetMyUserUseCase {
    suspend operator fun invoke(
        name: String?,
        profileImageUrl: String?
    ): Result<Unit>
}