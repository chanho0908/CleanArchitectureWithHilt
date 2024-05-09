package kr.suwon.chanho.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.suwon.chanho.data.usecase.LoginUseCaseImpl
import kr.suwon.chanho.domain.usecase.login.LoginUseCase

@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {
    @Binds
    abstract fun bindLoginUseCase(useCase: LoginUseCaseImpl): LoginUseCase
}