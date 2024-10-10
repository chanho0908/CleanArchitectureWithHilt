package kr.suwon.chanho.data.usecase.main.setting

import kr.suwon.chanho.data.model.toDomainModel
import kr.suwon.chanho.data.retrofit.UserService
import kr.suwon.chanho.domain.model.User
import kr.suwon.chanho.domain.usecase.main.setting.GetMyUserUseCase
import javax.inject.Inject

internal class GetMyUserUseCaseImpl @Inject constructor(
    private val userService: UserService
) : GetMyUserUseCase {
    override suspend fun invoke(): Result<User> = runCatching {
        userService.getMyPage().data.toDomainModel()
    }
}