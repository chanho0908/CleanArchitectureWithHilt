package kr.suwon.chanho.data.usecase.login

import kr.suwon.chanho.data.model.SignUpParam
import kr.suwon.chanho.data.retrofit.UserService
import kr.suwon.chanho.domain.usecase.login.SignUpUseCase
import javax.inject.Inject

internal class SignUpUseCaseImpl @Inject constructor(
    private val userService: UserService
) : SignUpUseCase {
    override suspend fun invoke(id: String, username: String, password: String): Result<Boolean> = runCatching {
        val requestBody = SignUpParam(
            loginId = id,
            name = username,
            password = password,
            extraUserInfo = "",
            profileFilePath = ""
        ).toRequestBody()
        userService.signUp(requestBody = requestBody).result == "SUCCESS"
    }
}