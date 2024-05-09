package kr.suwon.chanho.domain.usecase.login

interface GetTokenUseCase {
    suspend operator fun invoke(): String?
}