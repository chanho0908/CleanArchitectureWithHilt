package kr.suwon.chanho.domain.usecase.main.setting

import kr.suwon.chanho.domain.model.User

interface GetMyProfileUseCase {
    suspend operator fun invoke(): Result<User>
}