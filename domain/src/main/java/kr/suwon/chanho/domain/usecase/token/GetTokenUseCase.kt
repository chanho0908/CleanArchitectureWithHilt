package kr.suwon.chanho.domain.usecase.token

interface GetTokenUseCase {
    suspend operator fun invoke(): String?
}