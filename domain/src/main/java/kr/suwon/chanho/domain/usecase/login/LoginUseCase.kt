package kr.suwon.chanho.domain.usecase.login

interface LoginUseCase {
    suspend operator fun invoke(id: String, password:String): Result<String>
}