package xyz.tangjiabin.bzbook.screens.top

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import xyz.tangjiabin.bzbook.graph.OtherScreen
import xyz.tangjiabin.bzbook.screens.bottom.BottomBarScreen

/**
 * 顶部条
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-23
 */

@Composable
fun TopBarScreen(
    navController: NavHostController
) {

    val screens = listOf(
        BottomBarScreen.Bookshelf,
        BottomBarScreen.Classification,
        BottomBarScreen.Me,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val screen: BottomBarScreen? = screens.find { it.route == currentDestination?.route }

    var title = ""
    if (screen != null) {
        title = screen.title
    }

    val onSearchClicked = { navController.navigate(OtherScreen.Search.route) }
    val onMenuClicked = { }

    val bottomBarDestination = screen != null


    if (bottomBarDestination) {
        DefaultAppBar(
            title = title,
            onSearchClicked = onSearchClicked,
            onMenuClicked = onMenuClicked
        )
    }


}

@Composable
fun DefaultAppBar(title: String, onSearchClicked: () -> Unit, onMenuClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Black
            )
        },
        actions = {
            IconButton(
                onClick = { onSearchClicked() }
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon",
                    tint = MaterialTheme.colors.onBackground
                )
            }
            IconButton(
                onClick = { onMenuClicked() }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu Icon",
                    tint = MaterialTheme.colors.onBackground
                )
            }
        },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp
    )
}

