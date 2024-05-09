package kr.suwon.chanho.presentation.login

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.suwon.chanho.presentation.signup.SignUpScreen
import kr.suwon.chanho.presentation.welcome.WelcomeScreen

@Composable
fun LoginNavHost(){

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = LoginRoute.WelcomeScreen.name,
    ){
        composable(route = LoginRoute.WelcomeScreen.name){
            WelcomeScreen(
                onNavigateToLoginScreen = {
                    navController.navigate(route = LoginRoute.LoginScreen.name)
                }
            )
        }

        composable(route = LoginRoute.LoginScreen.name){
            LoginScreen(
                onNavigateToSignUpScreen = {
                    navController.navigate(route = LoginRoute.SignUpScreen.name)
                }
            )
        }

        composable(route = LoginRoute.SignUpScreen.name){
            SignUpScreen(id = "asd",
                username = "Charles",
                password1 = "test1234",
                password2 = "test1234",
                onIdChange = {},
                onUsernameChange = {},
                onPassword1Change = {},
                onPassword2Change = {},
                onSignUpClick = {}
                )
        }
    }
}