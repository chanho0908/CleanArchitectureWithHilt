package kr.suwon.chanho.data.model

import kotlinx.serialization.Serializable

@Serializable
internal data class CommonResponse<T>(
    val result: String,
    val data: T,
    val errorCode: String,
    val errorMessage: String,
)