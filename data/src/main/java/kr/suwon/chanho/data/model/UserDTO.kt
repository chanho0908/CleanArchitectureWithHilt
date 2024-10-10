package kr.suwon.chanho.data.model

import kotlinx.serialization.Serializable
import kr.suwon.chanho.domain.model.User

@Serializable
internal data class UserDTO(
    val id: Long,
    val loginId: String,
    val userName: String,
    val extraUserInfo: String,
    val profileFilePath: String,
)

internal fun UserDTO.toDomainModel(): User {
    return User(
        id = this.id,
        loginId = this.loginId,
        username = this.userName,
        profileImageUrl = this.profileFilePath
    )
}