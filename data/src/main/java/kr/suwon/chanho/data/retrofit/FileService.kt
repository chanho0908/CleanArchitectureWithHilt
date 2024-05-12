package kr.suwon.chanho.data.retrofit

import kr.suwon.chanho.data.dto.response.ImageResponse
import kr.suwon.chanho.data.dto.response.CommonResponse
import okhttp3.MultipartBody
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface FileService {

    @Multipart
    @POST("files")
    @Headers("ContentType: multipart/form-data;")
    suspend fun uploadImage(
        @Part fileName: MultipartBody.Part,
        @Part file: MultipartBody.Part
    ): CommonResponse<ImageResponse>
}