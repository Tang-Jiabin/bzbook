package xyz.tangjiabin.bzbook.screens.bookshelf

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import xyz.tangjiabin.bzbook.R
import xyz.tangjiabin.bzbook.data.Book
import xyz.tangjiabin.bzbook.data.EditButtonStateEnum
import xyz.tangjiabin.bzbook.data.EditStateViewModel
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
    val editState: EditStateViewModel = viewModel()
    val bookList: List<Book> = getBookshelfContent()
    BookshelfList(bookList = bookList, editState = editState, navController = navController)

}

@Composable
private fun getBookshelfContent(): List<Book> {
    val cover = "https://tva4.sinaimg.cn/large/0072Vf1pgy1foxkieg2ntj31kw0w07su.jpg"
    return listOf(
        Book("书", "作者1", cover, "简介", "完本", "120万字", "第一千三百五十四章 空间顶顶顶"),
        Book("书籍", "作者2", cover, "简介", "连载中", "120万字", "第二千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名", "作者3", cover, "简介", "完本", "120万字", "第三千三百五十四章 空间顶顶顶"),
        Book("书籍名称", "作者4", cover, "简介", "连载中", "120万字", "第四千三百五十四章 空间顶顶顶")
    )
}

@Composable
fun BookshelfList(bookList: List<Book>, editState: EditStateViewModel, navController: NavHostController) {
    Column(modifier = Modifier.padding(10.dp)) {


        //统计及编辑按钮
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "您的藏书共 ${bookList.size} 本",
                fontSize = 14.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.padding(10.dp)
            )

            if (editState.editButtonState.value == EditButtonStateEnum.CLOSED) {
                Text(
                    text = "编辑",
                    fontSize = 14.sp,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable { editState.updateEditButtonState(EditButtonStateEnum.OPENED) }
                )
            } else {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "删除",
                        fontSize = 14.sp,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable { editState.updateEditButtonState(EditButtonStateEnum.CLOSED) }
                    )
                    Text(
                        text = "完成",
                        fontSize = 14.sp,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable { editState.updateEditButtonState(EditButtonStateEnum.CLOSED) }
                    )
                }
            }


        }

        //书架列表
        LazyVerticalGrid(
            columns = GridCells.Adaptive(100.dp),
        ) {
            items(bookList) {
                BookshelfContent(it, editState, navController)
            }
        }

    }


}

@Composable
fun BookshelfContent(book: Book, editState: EditStateViewModel, navController: NavHostController) {
    val checkboxState = remember {
        mutableStateOf(false)
    }

    Box(contentAlignment = Alignment.TopEnd,
        modifier = Modifier
            .width(100.dp)
            .padding(10.dp)
            .clickable {
                Log.d("Tang", book.name)

                if (editState.editButtonState.value == EditButtonStateEnum.OPENED) {
                    checkboxState.value = !checkboxState.value
                } else {
                    navController.navigate(OtherScreen.Read.route)
                }
            },
        content = {

            Column() {

                val painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(book.cover)
                        .placeholder(R.drawable.ic_baseline_menu_24)
                        .error(R.drawable.ic_baseline_menu_24)
                        .crossfade(true)
                        .transformations(RoundedCornersTransformation(8f))
                        .build()
                )
                //封面图片
                var modifier: Modifier = Modifier.fillMaxWidth().height(120.dp)
                if (checkboxState.value) {
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .border(2.dp, Color.Blue)
                }
                Image(
                    painter,
                    contentDescription = book.name,
                    contentScale = ContentScale.FillBounds,
                    modifier = modifier
                )
                //书名
                Text(
                    text = book.name,
                    fontSize = 15.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.padding(top = 10.dp)
                )
                //章节
                Text(
                    text = book.chapter,
                    fontSize = 12.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = Color.Gray
                )
            }

            if (editState.editButtonState.value == EditButtonStateEnum.OPENED) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .offset(5.dp, (-5).dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .size(20.dp)

                ) {
                    RadioButton(
                        selected = checkboxState.value,
                        onClick = { checkboxState.value = !checkboxState.value },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Blue,
                            disabledColor = Color.White,
                            unselectedColor = Color.Black,
                        ),
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
            }
        })


}

