package kr.suwon.chanho.domain.usecase.file

import kr.suwon.chanho.domain.model.Image

interface GetImageUseCase {
    operator fun invoke(contentUri: String): Image?
}