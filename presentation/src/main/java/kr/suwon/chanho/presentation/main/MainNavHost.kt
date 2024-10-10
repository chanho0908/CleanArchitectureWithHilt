package kr.suwon.chanho.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.suwon.chanho.presentation.R
import kr.suwon.chanho.presentation.main.board.BoardScreen
import kr.suwon.chanho.presentation.main.board.BoardViewModel
import kr.suwon.chanho.presentation.main.setting.SettingScreen

@ExperimentalMaterial3Api
@Composable
fun MainNavHost(boardViewModel: BoardViewModel) {
    val navController = rememberNavController()

    Surface {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(R.string.app_name))
                    },
                    modifier = Modifier.background(MaterialTheme.colorScheme.background)
                )
            },
            content = { padding ->
                NavHost(
                    navController = navController,
                    startDestination = MainRoute.BOARD.route,
                    modifier = Modifier.padding(padding)
                ){
                    composable(route = MainRoute.BOARD.route){
                        BoardScreen(boardViewModel)
                    }
                    composable(route = MainRoute.SETTING.route){
                        SettingScreen()
                    }
                }
            },
            bottomBar = {
                MainBottomBar(
                    navController = navController
                )
            }
        )
    }
}