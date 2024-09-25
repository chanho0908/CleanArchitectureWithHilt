package kr.suwon.chanho.data.retrofit

import kr.suwon.chanho.data.model.CommonResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

internal interface UserService {

    @POST("users/login")
    suspend fun login(
        @Body requestBody: RequestBody
    ): CommonResponse<String>

    @POST("users/sign-up")
    suspend fun signUp(
        @Body requestBody: RequestBody
    ):CommonResponse<Long>
}