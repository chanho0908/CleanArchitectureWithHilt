package kr.suwon.chanho.presentation.login

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import kr.suwon.chanho.presentation.theme.ConnectedTheme

class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ConnectedTheme {
                LoginNavHost()
            }
        }
    }
}