package kr.suwon.chanho.data.usecase.main.setting

import kr.suwon.chanho.data.dto.request.toDomainModel
import kr.suwon.chanho.data.retrofit.UserService
import kr.suwon.chanho.domain.model.User
import kr.suwon.chanho.domain.usecase.main.setting.GetMyProfileUseCase
import javax.inject.Inject

class GetMyProfileUseCaseImpl @Inject constructor(
    private val userService: UserService
): GetMyProfileUseCase {
    override suspend fun invoke(): Result<User> = runCatching {
        userService.getMyProfile().data.toDomainModel()
    }
}