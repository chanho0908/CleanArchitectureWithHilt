package kr.suwon.chanho.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kr.suwon.chanho.domain.usecase.login.GetTokenUseCase
import kr.suwon.chanho.presentation.login.LoginActivity
import kr.suwon.chanho.presentation.main.MainActivity
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity: AppCompatActivity(){
    @Inject
    lateinit var getTokenUseCase: GetTokenUseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            val isLoggedIn = !getTokenUseCase().isNullOrEmpty()

            if (isLoggedIn){
                startActivity(
                    Intent(
                        this@SplashActivity, MainActivity::class.java
                    ).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                )
            }else{
                startActivity(
                    Intent(
                        this@SplashActivity, LoginActivity::class.java
                    ).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                )
            }
        }
    }
}