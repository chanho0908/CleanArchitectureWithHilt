package kr.suwon.chanho.data.dto.request

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

@Serializable
data class UpdateMyInfoRequest (
    val userName: String,
    val extraUserInfo: String,
    val profileFilePath: String,
)

fun UpdateMyInfoRequest.toRequestBody(): RequestBody{
    return Json.encodeToString(this).toRequestBody()
}