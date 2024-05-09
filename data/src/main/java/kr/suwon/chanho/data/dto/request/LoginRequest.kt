package kr.suwon.chanho.data.dto.request

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

@Serializable
data class LoginRequest (
    val loginId: String,
    val password: String
)

fun LoginRequest.toRequestBody(): RequestBody{
    return Json.encodeToString(this).toRequestBody()
}