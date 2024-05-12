package kr.suwon.chanho.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.suwon.chanho.data.usecase.login.LoginUseCaseImpl
import kr.suwon.chanho.data.usecase.login.SignUpUseCaseImpl
import kr.suwon.chanho.data.usecase.main.setting.GetMyProfileUseCaseImpl
import kr.suwon.chanho.data.usecase.main.setting.SetMyUserUseCaseImpl
import kr.suwon.chanho.data.usecase.main.setting.SetProfileImageUseCaseImpl
import kr.suwon.chanho.data.usecase.token.ClearTokenUseCaseImpl
import kr.suwon.chanho.data.usecase.token.GetTokenUseCaseImpl
import kr.suwon.chanho.data.usecase.token.SetTokenUseCaseImpl
import kr.suwon.chanho.domain.usecase.login.LoginUseCase
import kr.suwon.chanho.domain.usecase.login.SignUpUseCase
import kr.suwon.chanho.domain.usecase.main.setting.GetMyProfileUseCase
import kr.suwon.chanho.domain.usecase.main.setting.SetMyUserUseCase
import kr.suwon.chanho.domain.usecase.main.setting.SetProfileImageUseCase
import kr.suwon.chanho.domain.usecase.token.ClearTokenUseCase
import kr.suwon.chanho.domain.usecase.token.GetTokenUseCase
import kr.suwon.chanho.domain.usecase.token.SetTokenUseCase

@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {
    @Binds
    abstract fun bindLoginUseCase(useCase: LoginUseCaseImpl): LoginUseCase

    @Binds
    abstract fun bindSignUpUseCase(useCase: SignUpUseCaseImpl): SignUpUseCase

    @Binds
    abstract fun bindGetTokenUserCase(useCase: GetTokenUseCaseImpl): GetTokenUseCase

    @Binds
    abstract fun bindClearTokenUserCase(useCase: ClearTokenUseCaseImpl): ClearTokenUseCase

    @Binds
    abstract fun bindSetTokenUserCase(useCase: SetTokenUseCaseImpl): SetTokenUseCase

    @Binds
    abstract fun bindGetMyProfileUseCase(useCse: GetMyProfileUseCaseImpl): GetMyProfileUseCase

    @Binds
    abstract fun bindUpdateMyNameUseCase(useCase: SetMyUserUseCaseImpl): SetMyUserUseCase

    @Binds
    abstract fun bindSetProfileImageUseCase(useCase: SetProfileImageUseCaseImpl): SetProfileImageUseCase
}