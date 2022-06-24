package xyz.tangjiabin.bzbook.graph

/**
 * 首页导航
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-23
 */

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import xyz.tangjiabin.bzbook.screens.bottom.BottomBarScreen
import xyz.tangjiabin.bzbook.screens.classification.ClassificationScreen
import xyz.tangjiabin.bzbook.screens.details.DetailsScreen
import xyz.tangjiabin.bzbook.screens.bookshelf.BookshelfScreen
import xyz.tangjiabin.bzbook.screens.me.MeScreen
import xyz.tangjiabin.bzbook.screens.read.ReadScreen
import xyz.tangjiabin.bzbook.screens.search.SearchScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Bookshelf.route
    ) {

        //书架
        composable(route = BottomBarScreen.Bookshelf.route) {
            BookshelfScreen(navController)
        }
        //分类
        composable(route = BottomBarScreen.Classification.route) {
            ClassificationScreen(
                name = BottomBarScreen.Classification.route,
                onClick = { navController.navigate(OtherScreen.Search.route) }
            )
        }
        //我的
        composable(route = BottomBarScreen.Me.route) {
            MeScreen(
                name = BottomBarScreen.Me.route,
                onClick = { navController.navigate(OtherScreen.Login.route) }
            )
        }
        //阅读
        composable(route = OtherScreen.Read.route) {
            ReadScreen(
                name = OtherScreen.Read.route,
                onClick = {}
            )
        }
        //搜索
        composable(route = OtherScreen.Search.route) {
            SearchScreen(
                name = OtherScreen.Search.route,
                onClick = { navController.navigate(OtherScreen.Details.route) }
            )
        }
        //详情
        composable(route = OtherScreen.Details.route) {
            DetailsScreen(
                name = OtherScreen.Details.route,
                onClick = {}
            )
        }
        //登录
        composable(route = OtherScreen.Login.route) {
            DetailsScreen(
                name = OtherScreen.Login.route,
                onClick = { navController.navigate(BottomBarScreen.Me.route) }
            )
        }
    }
}

sealed class OtherScreen(val route: String) {
    object Read : OtherScreen(route = "READ")
    object Login : OtherScreen(route = "LOGIN")
    object Search : OtherScreen(route = "SEARCH")
    object Details : OtherScreen(route = "DETAILS")
}
