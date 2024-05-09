package kr.suwon.chanho.domain.usecase.login

interface SetTokenUseCase {
    suspend operator fun invoke(token: String)
}