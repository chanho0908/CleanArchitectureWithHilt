package kr.suwon.chanho.presentation.login

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import kr.suwon.chanho.presentation.login.screen.LoginScreen
import kr.suwon.chanho.presentation.login.screen.SignUpScreen
import kr.suwon.chanho.presentation.login.screen.WelcomeScreen

@Composable
fun LoginNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LoginRoute.WelcomeScreen.name
    ){
        composable(route = LoginRoute.WelcomeScreen.name){
            WelcomeScreen(
                onNavigateToLoginScreen = {
                    navController.navigate(route = LoginRoute.LoginScreen.name)
                }
            )
        }
        composable(route = LoginRoute.LoginScreen.name) {
            LoginScreen(
                onNavigateToSignUpScreen = {
                    navController.navigate(route = LoginRoute.SignUpScreen.name)
                }
            )
        }
        composable(route = LoginRoute.SignUpScreen.name) {
            SignUpScreen(
                onNavigateToLoginScreen = {
                    navController.navigate(
                        route = LoginRoute.LoginScreen.name,
                        navOptions = navOptions {
                            popUpTo(LoginRoute.WelcomeScreen.name)
                        }
                    )
                }
            )
        }
    }
}