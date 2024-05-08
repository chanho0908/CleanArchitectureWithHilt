package kr.suwon.chanho.domain.usecase.login

interface LoginUseCase {
    suspend fun login(
        id: String,
        password: String)
    : Result<String>
}