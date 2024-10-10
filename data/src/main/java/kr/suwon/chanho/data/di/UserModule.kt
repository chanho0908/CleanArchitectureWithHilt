package kr.suwon.chanho.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.suwon.chanho.data.usecase.login.LoginUseCaseImpl
import kr.suwon.chanho.data.usecase.login.SignUpUseCaseImpl
import kr.suwon.chanho.data.usecase.main.setting.GetMyUserUseCaseImpl
import kr.suwon.chanho.data.usecase.main.setting.SetMyUserUseCaseImpl
import kr.suwon.chanho.data.usecase.main.setting.SetProfileImageUseCaseImpl
import kr.suwon.chanho.data.usecase.token.ClearTokenUseCaseImpl
import kr.suwon.chanho.data.usecase.token.GetTokenUseCaseImpl
import kr.suwon.chanho.data.usecase.token.SetTokenUseCaseImpl
import kr.suwon.chanho.domain.usecase.login.LoginUseCase
import kr.suwon.chanho.domain.usecase.login.SignUpUseCase
import kr.suwon.chanho.domain.usecase.main.setting.GetMyUserUseCase
import kr.suwon.chanho.domain.usecase.main.setting.SetMyUserUseCase
import kr.suwon.chanho.domain.usecase.main.setting.SetProfileImageUseCase
import kr.suwon.chanho.domain.usecase.token.ClearTokenUseCase
import kr.suwon.chanho.domain.usecase.token.GetTokenUseCase
import kr.suwon.chanho.domain.usecase.token.SetTokenUseCase

@Module
@InstallIn(SingletonComponent::class)
internal abstract class UserModule{

    @Binds
    abstract fun bindUserUseCase(uc: LoginUseCaseImpl): LoginUseCase

    @Binds
    abstract fun bindSignUpUseCase(uc: SignUpUseCaseImpl): SignUpUseCase

    @Binds
    abstract fun bindGetTokenUseCase(uc: GetTokenUseCaseImpl): GetTokenUseCase

    @Binds
    abstract fun bindSetTokenUseCase(uc: SetTokenUseCaseImpl): SetTokenUseCase

    @Binds
    abstract fun bindClearTokenUseCase(uc: ClearTokenUseCaseImpl): ClearTokenUseCase

    @Binds
    abstract fun bindGetMyUserUseCase(uc: GetMyUserUseCaseImpl): GetMyUserUseCase

    @Binds
    abstract fun bindUpdateMyNameUseCase(uc: SetMyUserUseCaseImpl): SetMyUserUseCase

    @Binds
    abstract fun bindSetProfileImageUseCase(uc: SetProfileImageUseCaseImpl): SetProfileImageUseCase

}