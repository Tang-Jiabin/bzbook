package xyz.tangjiabin.bzbook


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch
import xyz.tangjiabin.bzbook.ui.theme.BZTheme
import xyz.tangjiabin.bzbook.data.BZViewModel
import xyz.tangjiabin.bzbook.ui.Bookshelf
import xyz.tangjiabin.bzbook.ui.BottomBar
import xyz.tangjiabin.bzbook.ui.Me
import xyz.tangjiabin.bzbook.ui.Search


class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //开启沉浸式状态栏
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val viewModel: BZViewModel = viewModel()
            //设置透明
            val systemUiController = rememberSystemUiController()
            SideEffect {
                systemUiController.setStatusBarColor(Color.Transparent, darkIcons = false)
            }
            BZTheme(viewModel.darkTheme.value) {
                Column {
                    val pageState = rememberPagerState()
                    HorizontalPager(count = 3, Modifier.weight(1f), pageState) { page ->
                        when (page) {
                            0 -> Bookshelf(viewModel.books.value)
                            1 -> Search()
                            2 -> Me()
                        }
                    }
                    val scope = rememberCoroutineScope()
                    BottomBar(pageState.currentPage) { page ->
                        scope.launch {
                            pageState.animateScrollToPage(page)
                        }
                    }
                }
            }
        }
    }


}

