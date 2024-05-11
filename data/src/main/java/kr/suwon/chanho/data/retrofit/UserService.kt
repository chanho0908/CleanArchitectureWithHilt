package kr.suwon.chanho.data.retrofit

import kr.suwon.chanho.data.dto.request.UserRequest
import kr.suwon.chanho.data.dto.response.CommonResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {

    @POST("users/login")
    suspend fun login(
        @Body requestBody: RequestBody
    ):CommonResponse<String>

    @POST("users/sign-up")
    suspend fun signUp(
        @Body requestBody: RequestBody
    ):CommonResponse<Long>

    @GET("users/my-page")
    suspend fun getMyProfile():CommonResponse<UserRequest>

}