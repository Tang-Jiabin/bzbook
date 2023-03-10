package xyz.tangjiabin.bzbook.screens.bookshelf

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import xyz.tangjiabin.bzbook.R
import xyz.tangjiabin.bzbook.database.entity.BookEntity
import xyz.tangjiabin.bzbook.graph.OtherScreen
import xyz.tangjiabin.bzbook.screens.bottom.BottomBarScreen

/**
 * 书架（首页）内容
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-23
 */

@Composable
fun BookshelfScreen(navController: NavHostController, viewModel: BookshelfViewModel = hiltViewModel()) {


    LaunchedEffect(Unit) {
        viewModel.getAllBook()
    }

    BookshelfList(viewModel = viewModel, navController = navController)


}


@Composable
fun BookshelfList(
    viewModel: BookshelfViewModel,
    navController: NavHostController
) {

    val bookList = viewModel.bookList

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

            if (viewModel.editButtonState.value == EditButtonStateEnum.CLOSED) {
                Text(
                    text = "编辑",
                    fontSize = 14.sp,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable { viewModel.updateEditButtonState(EditButtonStateEnum.OPENED) }
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
                            .clickable { viewModel.deleteBook() }
                    )
                    Text(
                        text = "完成",
                        fontSize = 14.sp,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable { viewModel.updateEditButtonState(EditButtonStateEnum.CLOSED) }
                    )
                }
            }
        }

        //书架列表
        LazyVerticalGrid(
            columns = GridCells.Adaptive(100.dp),
        ) {
            items(bookList) {
                BookshelfContent(it, viewModel, navController)
            }
            item {
                Column(modifier = Modifier.padding(10.dp)) {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_add_circle_outline_24),
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier
                            .clickable {
                                navController.navigate(BottomBarScreen.Classification.route)
//                                viewModel.addBookshelf(
//                                    BookEntity(
//                                        0,
//                                        "书籍名称" + Random.nextInt(100),
//                                        "作者" + Random.nextInt(100),
//                                        "https://picsum.photos/200/300?" + Random.nextInt(100),
//                                        "第" + Random.nextInt(10000) + "章"
//                                    )
//                                )
                            }
                            .height(120.dp)
                            .width(100.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(MaterialTheme.colors.onBackground.copy(0.1f)))

                    Spacer(modifier = Modifier.padding(60.dp))
                }


            }

        }


    }


}

@Composable
fun BookshelfContent(book: BookEntity, viewModel: BookshelfViewModel, navController: NavHostController) {

    Box(contentAlignment = Alignment.TopEnd,
        modifier = Modifier
            .width(100.dp)
            .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 20.dp)
            .clickable {
                if (viewModel.editButtonState.value == EditButtonStateEnum.OPENED) {

                    if (!viewModel.delBookList.contains(book)) {
                        viewModel.addDelBook(book)
                    } else {
                        viewModel.removeDelBook(book)
                    }
                } else {
                    navController.navigate(OtherScreen.Read.route)
                }
            },
        content = {

            Column() {

                val painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(book.cover)
                        .placeholder(R.drawable.ic_baseline_image_24)
                        .error(R.drawable.ic_baseline_image_24)
                        .crossfade(true)
                        .transformations(RoundedCornersTransformation(8f))
                        .build()
                )
                //封面图片
                var modifier: Modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                if (viewModel.delBookList.contains(book)) {
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

            if (viewModel.editButtonState.value == EditButtonStateEnum.OPENED) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .offset(5.dp, (-5).dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .size(20.dp)

                ) {
                    RadioButton(
                        selected = viewModel.delBookList.contains(book),
                        onClick = {
                            if (!viewModel.delBookList.contains(book)) {
                                viewModel.addDelBook(book)
                            } else {
                                viewModel.removeDelBook(book)
                            }
                        },
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

