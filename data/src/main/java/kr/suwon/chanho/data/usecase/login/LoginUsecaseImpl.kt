package kr.suwon.chanho.data.usecase.login

import kr.suwon.chanho.data.model.LoginParam
import kr.suwon.chanho.data.retrofit.UserService
import kr.suwon.chanho.domain.usecase.login.LoginUseCase
import javax.inject.Inject

internal class LoginUseCaseImpl @Inject constructor(
    private val userService: UserService,
) : LoginUseCase {
    override suspend fun invoke(id: String, password: String): Result<String> = kotlin.runCatching {
        val requestBody = LoginParam(loginId = id, password = password).toRequestBody()
        userService.login(requestBody = requestBody).data
    }
}