package kr.suwon.chanho.data.retrofit

import android.util.Log
import kr.suwon.chanho.domain.usecase.file.GetInputStreamUseCase
import okhttp3.MediaType
import okhttp3.RequestBody
import okio.BufferedSink
import okio.source
import java.io.FileNotFoundException

class UriRequestBody(
    private val contentUri: String,
    private val getInputStreamUseCase: GetInputStreamUseCase,
    private val contentType: MediaType? = null
): RequestBody() {
    override fun contentType(): MediaType? {
        return contentType
    }

    override fun writeTo(sink: BufferedSink) {
        try {
            getInputStreamUseCase(
                contentUri = contentUri
            )
            .getOrThrow()
            .use { inputStream ->
                sink.writeAll(inputStream.source())
            }
        } catch (e: FileNotFoundException) {
            Log.e("UriRequestBody", e.message.orEmpty())
        }
    }

}