package xyz.tangjiabin.bzbook.screens.bookshelf

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import xyz.tangjiabin.bzbook.R
import xyz.tangjiabin.bzbook.data.Book
import xyz.tangjiabin.bzbook.graph.OtherScreen

/**
 * 书架（首页）内容
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-23
 */

@Composable
fun BookshelfScreen(navController: NavHostController) {

    val bookList: List<Book> = getBookshelfContent()
    BookshelfList(bookList = bookList, navController = navController)

}

@Composable
private fun getBookshelfContent(): List<Book> {
    val cover = "https://tva4.sinaimg.cn/large/0072Vf1pgy1foxkieg2ntj31kw0w07su.jpg"
    return listOf(
        Book("shuji1", "作者1", cover, "简介", "完本", "120万字", "第一千三百五十四章 空间顶顶顶"),
        Book("shuji2", "作者2", cover, "简介", "连载中", "120万字", "第二千三百五十四章 空间顶顶顶"),
        Book("shuji3", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("shuji4", "作者4", cover, "简介", "连载中", "120万字", "第四千三百五十四章 空间顶顶顶")
    )
}

@Composable
fun BookshelfList(bookList: List<Book>, navController: NavHostController) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            text = "您的书架藏书共 ${bookList.size} 本",
            fontSize = 14.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
        LazyVerticalGrid(
            columns = GridCells.Adaptive(100.dp),
        ) {
            items(bookList) {
                BookshelfContent(it, navController)
            }
        }
    }


}

@Composable
fun BookshelfContent(book: Book, navController: NavHostController) {

    Box(contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Red)
            .clickable { navController.navigate(OtherScreen.Read.route) },
        content = {
            Column() {

                val painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(book.cover)
                        .placeholder(R.drawable.ic_baseline_menu_24)
                        .error(R.drawable.ic_baseline_menu_24)
                        .crossfade(true)
                        .transformations(RoundedCornersTransformation(4f))
                        .build()
                )

                Image(
                    painter,
                    contentDescription = book.name,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(100.dp)
                        .height(120.dp)
                )
                Text(text = book.name, fontSize = 16.sp, overflow = TextOverflow.Ellipsis, maxLines = 1)
                Text(text = book.chapter, fontSize = 10.sp, overflow = TextOverflow.Ellipsis, maxLines = 1)
            }
        })


}

