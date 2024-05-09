package kr.suwon.chanho.data.usecase

import kr.suwon.chanho.data.dto.request.LoginRequest
import kr.suwon.chanho.data.dto.request.toRequestBody
import kr.suwon.chanho.data.service.UserService
import kr.suwon.chanho.domain.usecase.login.LoginUseCase
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(
    private val userService: UserService
): LoginUseCase {
    override suspend fun invoke(id: String, password: String): Result<String>  = runCatching{
        val requestBody = LoginRequest(id, password).toRequestBody()
        userService.login(requestBody).data
    }
}