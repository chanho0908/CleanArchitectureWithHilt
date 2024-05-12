package kr.suwon.chanho.data.usecase.file

import kr.suwon.chanho.data.retrofit.FileService
import kr.suwon.chanho.data.retrofit.UriRequestBody
import kr.suwon.chanho.domain.model.Image
import kr.suwon.chanho.domain.usecase.file.GetInputStreamUseCase
import kr.suwon.chanho.domain.usecase.file.UploadImageUseCase
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import javax.inject.Inject

class UploadImageUseCaseImpl @Inject constructor(
    private val fileService: FileService,
    private val getInputStreamUseCase: GetInputStreamUseCase
) : UploadImageUseCase {
    override suspend fun invoke(image: Image): Result<String> = runCatching{

        val fileName = MultipartBody.Part.createFormData(
            "fileName",
            image.name
        )

        val requestBody = UriRequestBody(
            image.uri,
            getInputStreamUseCase,
            image.mimeType.toMediaType()
        )

        val file = MultipartBody.Part.createFormData(
            "file",
            image.name,
            requestBody
        )

        fileService.uploadImage(
            fileName = fileName,
            file = file
        ).data.filePath
    }
}