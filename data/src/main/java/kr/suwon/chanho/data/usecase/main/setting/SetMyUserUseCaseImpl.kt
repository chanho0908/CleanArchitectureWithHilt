package kr.suwon.chanho.data.usecase.main.setting

import kr.suwon.chanho.data.model.UpdateMyInfoParam
import kr.suwon.chanho.data.retrofit.UserService
import kr.suwon.chanho.domain.usecase.main.setting.GetMyUserUseCase
import kr.suwon.chanho.domain.usecase.main.setting.SetMyUserUseCase
import javax.inject.Inject

internal class SetMyUserUseCaseImpl @Inject constructor(
    private val userService: UserService,
    private val getMyUserUseCase: GetMyUserUseCase
) : SetMyUserUseCase {
    override suspend fun invoke(
        username: String?,
        profileImageUrl: String?
    ): Result<Unit> = kotlin.runCatching {
        val user = getMyUserUseCase()
        user?.let {
            val requestBody = UpdateMyInfoParam(
                userName = username!!,
                profileFilePath = profileImageUrl.orEmpty(),
                extraUserInfo = ""
            ).toRequestBody()
            userService.patchMyPage(requestBody)
        }
    }
}