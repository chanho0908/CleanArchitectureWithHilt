package kr.suwon.chanho.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.suwon.chanho.data.usecase.ClearTokenUseCaseImpl
import kr.suwon.chanho.data.usecase.GetTokenUseCaseImpl
import kr.suwon.chanho.data.usecase.LoginUseCaseImpl
import kr.suwon.chanho.data.usecase.SetTokenUseCaseImpl
import kr.suwon.chanho.data.usecase.SignUpUseCaseImpl
import kr.suwon.chanho.domain.usecase.login.ClearTokenUseCase
import kr.suwon.chanho.domain.usecase.login.GetTokenUseCase
import kr.suwon.chanho.domain.usecase.login.LoginUseCase
import kr.suwon.chanho.domain.usecase.login.SetTokenUseCase
import kr.suwon.chanho.domain.usecase.login.SignUpUseCase

@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {
    @Binds
    abstract fun bindLoginUseCase(useCase: LoginUseCaseImpl): LoginUseCase

    @Binds
    abstract fun bindSignUpUseCase(useCase: SignUpUseCaseImpl): SignUpUseCase

    @Binds
    abstract fun getTokenUserCase(useCase: GetTokenUseCaseImpl): GetTokenUseCase

    @Binds
    abstract fun clearTokenUserCase(useCase: ClearTokenUseCaseImpl): ClearTokenUseCase

    @Binds
    abstract fun setTokenUserCase(useCase: SetTokenUseCaseImpl): SetTokenUseCase
}