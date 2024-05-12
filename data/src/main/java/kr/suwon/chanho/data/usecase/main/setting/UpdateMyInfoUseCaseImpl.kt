package kr.suwon.chanho.data.usecase.main.setting

import android.util.Log
import kr.suwon.chanho.data.dto.request.UpdateMyInfoRequest
import kr.suwon.chanho.data.dto.request.toRequestBody
import kr.suwon.chanho.data.retrofit.UserService
import kr.suwon.chanho.domain.usecase.main.setting.GetMyProfileUseCase
import kr.suwon.chanho.domain.usecase.main.setting.UpdateMyNameUseCase
import javax.inject.Inject

class UpdateMyNameUseCaseImpl @Inject constructor(
    private val userService: UserService,
    private val getMyUserUseCase: GetMyProfileUseCase
): UpdateMyNameUseCase {

    override suspend fun invoke(name: String?): Result<Unit> = runCatching{
        val user = getMyUserUseCase().getOrThrow()
        val requestBody = UpdateMyInfoRequest(
            userName = name?:user.username,
            profileFilePath = "",
            extraUserInfo = ""
        ).toRequestBody()
        userService.patchMyPage(requestBody)
    }
}