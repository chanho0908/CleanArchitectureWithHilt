package kr.suwon.chanho.domain.usecase.token

interface SetTokenUseCase {
    suspend operator fun invoke(token: String)
}