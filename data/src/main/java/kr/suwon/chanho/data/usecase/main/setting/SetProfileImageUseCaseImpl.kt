package kr.suwon.chanho.data.usecase.main.setting

import android.util.Log
import kr.suwon.chanho.domain.model.Image
import kr.suwon.chanho.domain.usecase.file.GetImageUseCase
import kr.suwon.chanho.domain.usecase.file.UploadImageUseCase
import kr.suwon.chanho.domain.usecase.main.setting.GetMyProfileUseCase
import kr.suwon.chanho.domain.usecase.main.setting.SetMyUserUseCase
import kr.suwon.chanho.domain.usecase.main.setting.SetProfileImageUseCase
import javax.inject.Inject

class SetProfileImageUseCaseImpl @Inject constructor(
    private val uploadImageUseCase: UploadImageUseCase,
    private val getImageUseCase: GetImageUseCase,
    private val setMyUserUseCase: SetMyUserUseCase,
    private val getMyUserUseCase: GetMyProfileUseCase,
) : SetProfileImageUseCase {

    override suspend fun invoke(uri: String): Result<Unit> = runCatching {

        // 0. 내 정보 가져오기
        val user = getMyUserUseCase().getOrThrow()

        // 1. 이미지 정보 가져오기
        val image: Image = getImageUseCase(uri)
            ?: throw NullPointerException("이미지를 찾을 수 없습니다.")

        // 2. 이미지 서버에 업로드
        val imagePath = uploadImageUseCase(image).getOrThrow()

        //4. 내 정보 업데이트
        setMyUserUseCase(user.username, imagePath).getOrThrow()
    }
}