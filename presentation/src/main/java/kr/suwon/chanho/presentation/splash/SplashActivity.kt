package kr.suwon.chanho.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kr.suwon.chanho.presentation.login.LoginActivity
import kr.suwon.chanho.presentation.main.MainActivity
import kr.suwon.chanho.presentation.splash.vm.SplashViewModel

@AndroidEntryPoint
class SplashActivity: AppCompatActivity(){
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.token.collect{
                    if (!it.isNullOrEmpty()){
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
    }
}