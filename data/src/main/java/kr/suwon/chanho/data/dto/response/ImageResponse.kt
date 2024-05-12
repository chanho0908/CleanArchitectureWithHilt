package kr.suwon.chanho.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class ImageResponse (
    val id: Long,
    val fileName: String,
    val createdAt: String,
    val filePath: String
)