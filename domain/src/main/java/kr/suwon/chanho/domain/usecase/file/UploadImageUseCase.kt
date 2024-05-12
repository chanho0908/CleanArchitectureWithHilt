package kr.suwon.chanho.domain.usecase.file

import kr.suwon.chanho.domain.model.Image


interface UploadImageUseCase {
    suspend operator fun invoke(image: Image): Result<String>
}