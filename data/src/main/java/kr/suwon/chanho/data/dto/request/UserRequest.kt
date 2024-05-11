package kr.suwon.chanho.data.dto.request

import kotlinx.serialization.Serializable
import kr.suwon.chanho.domain.model.User

@Serializable
data class UserRequest(
    val id: Long,
    val loginId: String,
    val userName: String,
    val extraUserInfo: String,
    val profileFilePath: String,
)

fun UserRequest.toDomainModel(): User {
    return User(
        id = this.id,
        loginId = this.loginId,
        username = this.userName,
        profileImageUrl = this.profileFilePath
    )
}
