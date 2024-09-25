package kr.suwon.chanho.presentation.login

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kr.suwon.chanho.presentation.theme.ConnectedTheme

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConnectedTheme {
                LoginNavHost()
            }
        }
    }
}