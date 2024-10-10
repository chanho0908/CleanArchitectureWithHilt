package kr.suwon.chanho.presentation.main

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import kr.suwon.chanho.presentation.main.writing.WritingActivity
import kr.suwon.chanho.presentation.theme.ConnectedTheme

@Composable
fun MainBottomBar(
    navController: NavController
) {
    // 현재 navBackStackEntry를 가져옴
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // 현재 route 정보를 가져옴
    val currentRoute = navBackStackEntry
        ?.destination
        ?.route
        ?.let { currentRoute -> MainRoute.values().find { route -> route.route == currentRoute } }
        ?: MainRoute.BOARD

    val context = LocalContext.current

    MainBottomBar(
        currentRoute = currentRoute,
        onItemClick = { newRoute ->
            when(newRoute){
                MainRoute.WRITING -> {
                    context.startActivity(Intent(context, WritingActivity::class.java))
                }
                MainRoute.BOARD,
                MainRoute.SETTING -> {
                    navController.navigate(route = newRoute.route){
                        // 탭으로 바텀네비게이션을 전환할 때 백스텍에 쌓이는 것을 방지
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route){
                                saveState = true
                            }
                            this.launchSingleTop = true
                            this.restoreState = true
                        }
                    }
                }
            }

        }
    )
}


@Composable
private fun MainBottomBar(
    currentRoute: MainRoute,
    onItemClick: (MainRoute) -> Unit
) {
    Column {
        Divider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MainRoute.values().forEach { route ->
                IconButton(
                    onClick = { onItemClick(route) }) {
                    Icon(
                        imageVector = route.icon,
                        contentDescription = route.contentDescription,
                        tint = if (currentRoute == route) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainBottomBarPreview() {
    ConnectedTheme {
        Surface {
            var currentRoute by remember { mutableStateOf(MainRoute.BOARD) }
            MainBottomBar(
                currentRoute = currentRoute,
                onItemClick = { route -> currentRoute = route }
            )
        }
    }
}