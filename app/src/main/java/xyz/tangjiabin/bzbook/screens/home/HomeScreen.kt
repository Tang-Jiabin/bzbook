package xyz.tangjiabin.bzbook.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import xyz.tangjiabin.bzbook.graph.HomeNavGraph
import xyz.tangjiabin.bzbook.screens.bottom.BottomBar
import xyz.tangjiabin.bzbook.screens.top.TopBarScreen


/**
 * 首页屏幕
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-23
 */

@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        topBar = { TopBarScreen(navController = navController) },
        bottomBar = { BottomBar(navController = navController) }
    ) {
        HomeNavGraph(navController = navController)
    }
}
