package kr.suwon.chanho.data.usecase.file

import android.content.Context
import android.net.Uri
import kr.suwon.chanho.domain.usecase.file.GetInputStreamUseCase
import java.io.InputStream
import java.lang.IllegalStateException
import javax.inject.Inject

class GetInputStreamUseCaseImpl @Inject constructor(
    private val context: Context
): GetInputStreamUseCase{
    override fun invoke(contentUri: String): Result<InputStream> = runCatching{
        val uri = Uri.parse(contentUri)
        context.contentResolver.openInputStream(uri)
            ?: throw IllegalStateException("InputStream Failed")
    }
}