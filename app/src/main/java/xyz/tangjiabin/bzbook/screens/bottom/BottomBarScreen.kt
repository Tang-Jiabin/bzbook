package xyz.tangjiabin.bzbook.screens.bottom


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

/**
 * 底部导航条
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-23
 */


@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Bookshelf,
        BottomBarScreen.Classification,
        BottomBarScreen.Me,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        BottomNavigation {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            var iconColor = MaterialTheme.colors.onBackground
            if (currentDestination?.hierarchy?.any {
                    it.route == screen.route
                } == true) {
                iconColor = Color.Green
            }
            Text(text = screen.title, color = iconColor)
        },
        icon = {
            var iconRes = screen.icon
            var iconColor = MaterialTheme.colors.onBackground
            if (currentDestination?.hierarchy?.any {
                    it.route == screen.route
                } == true) {
                iconRes = screen.icon
                iconColor = Color.Green
            }
            Icon(
                imageVector = iconRes,
                contentDescription = screen.title,
                tint = iconColor,
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = MaterialTheme.colors.onBackground,
        selectedContentColor = Color.Blue,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },modifier = Modifier.background(MaterialTheme.colors.background)

    )
}

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Bookshelf : BottomBarScreen(
        route = "BOOKSHELF",
        title = "书架",
        icon = Icons.Default.Home
    )

    object Classification : BottomBarScreen(
        route = "CLASSIFICATION",
        title = "分类",
        icon = Icons.Default.DateRange
    )

    object Me : BottomBarScreen(
        route = "ME",
        title = "我的",
        icon = Icons.Default.Person
    )
}
