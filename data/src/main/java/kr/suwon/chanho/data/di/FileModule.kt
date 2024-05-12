package kr.suwon.chanho.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.suwon.chanho.data.usecase.file.GetImageUseCaseImpl
import kr.suwon.chanho.data.usecase.file.GetInputStreamUseCaseImpl
import kr.suwon.chanho.data.usecase.file.UploadImageUseCaseImpl
import kr.suwon.chanho.domain.usecase.file.GetImageUseCase
import kr.suwon.chanho.domain.usecase.file.GetInputStreamUseCase
import kr.suwon.chanho.domain.usecase.file.UploadImageUseCase

@Module
@InstallIn(SingletonComponent::class)
abstract class FileModule {

    @Binds
    abstract fun bindGetInputStreamUseCase(useCase: GetInputStreamUseCaseImpl): GetInputStreamUseCase

    @Binds
    abstract fun bindGetImageUseCase(useCase: GetImageUseCaseImpl): GetImageUseCase

    @Binds
    abstract fun bindUploadImageUseCase(useCase: UploadImageUseCaseImpl): UploadImageUseCase
}