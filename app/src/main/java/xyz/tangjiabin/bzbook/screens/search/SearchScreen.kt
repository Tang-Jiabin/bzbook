package xyz.tangjiabin.bzbook.screens.search


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
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


/**
 * 搜索
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-23
 */

@Composable
fun SearchScreen(navController: NavHostController, viewModel: SearchViewModel = hiltViewModel()) {

    val focusRequester = FocusRequester()
    val localFocusManager = LocalFocusManager.current
    LaunchedEffect(Unit) { focusRequester.requestFocus() }



    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(top = 10.dp)

        ) {
            val textValue = viewModel.textValue.value
            BasicTextField(
                value = textValue, onValueChange = { viewModel.setTextValue(it) },
                singleLine = true,
                maxLines = 1,
                cursorBrush = SolidColor(MaterialTheme.colors.primary),
                textStyle = LocalTextStyle.current.copy(
                    color = MaterialTheme.colors.onBackground
                ),
                decorationBox = {innerTextField->
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "搜索",modifier = Modifier.padding(10.dp))
                        Box(Modifier.weight(1f)) {
                            if (textValue.isEmpty()) {
                                innerTextField()
                                Text(
                                    "请输入书名、作者",
                                    style = LocalTextStyle.current.copy(
                                        color = MaterialTheme.colors.onBackground.copy(0.3f)
                                    )
                                )
                            } else {
                                innerTextField()
                            }

                        }
                        var btnText = "搜索"
                        if (textValue.trim() == "") {
                            btnText = "取消"
                        }
                        Text(text = btnText,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colors.onBackground,
                            modifier = Modifier
                                .padding(start = 15.dp, end = 15.dp)
                                .clickable {

                                    if (textValue.trim() == "") {
                                        navController.navigateUp()
                                    } else {
                                        localFocusManager.clearFocus()
                                        viewModel.findBook()
                                    }
                                })
                    }
                },
                modifier = Modifier
                    .defaultMinSize(minHeight = 8.dp)
                    .height(45.dp)
                    .fillMaxWidth()
                    .focusRequester(focusRequester = focusRequester)
                    .padding(0.dp)
                    .border(
                        1.dp, MaterialTheme.colors.onBackground, RoundedCornerShape(20)
                    )
            )
//            TextField(
//                value = textValue,
//                placeholder = {
//                    Text("请输入书名、作者")
//                },
//                onValueChange = {
//                    viewModel.setTextValue(it)
//                },
//                singleLine = true,
//                maxLines = 1,
//                shape = RoundedCornerShape(5.dp),
//                leadingIcon = {
//                    Icon(imageVector = Icons.Default.Search, contentDescription = "")
//                },
//                trailingIcon = {
//
//                    var btnText = "搜索"
//                    if (textValue.trim() == "") {
//                        btnText = "取消"
//                    }
//                    Text(text = btnText,
//                        fontWeight = FontWeight.Bold,
//                        color = MaterialTheme.colors.onBackground,
//                        modifier = Modifier
//                            .padding(start = 10.dp, end = 10.dp)
//                            .clickable {
//
//                                if (textValue.trim() == "") {
//                                    navController.navigateUp()
//                                } else {
//                                    localFocusManager.clearFocus()
//                                    viewModel.findBook()
//                                }
//                            })
//
//                },
//                colors = TextFieldDefaults.textFieldColors(
//                    textColor = MaterialTheme.colors.onBackground,
//                    disabledTextColor = Color.Transparent,
//                    backgroundColor = MaterialTheme.colors.background,
//                    focusedIndicatorColor = Color.Transparent,
//                    unfocusedIndicatorColor = Color.Transparent,
//                    disabledIndicatorColor = Color.Transparent
//                ),
//                modifier = Modifier
//                    .defaultMinSize(minHeight = 8.dp)
//                    .height(45.dp)
//                    .fillMaxWidth()
//                    .focusRequester(focusRequester = focusRequester)
//                    .padding(0.dp)
//                    .border(
//                        1.dp, MaterialTheme.colors.onBackground, RoundedCornerShape(20)
//                    )
//            )
        }

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(viewModel.bookList) {
                BookContent(navController, it)
            }
            item { Spacer(modifier = Modifier.padding(40.dp)) }
        }
    }
}


@Composable
private fun BookContent(navController: NavHostController, book: BookEntity) {
    Card(
        modifier = Modifier
            .clickable { navController.navigate(OtherScreen.Details.route) }
            .fillMaxWidth()
            .height(80.dp)
            .padding(5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BookContentLeft(book)
            BookContentRight(book)
        }
    }
}

@Composable
private fun BookContentLeft(it: BookEntity) {
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(it.cover)
            .placeholder(R.drawable.ic_baseline_image_24)
            .error(R.drawable.ic_baseline_image_24)
            .crossfade(true)
            .transformations(RoundedCornersTransformation(8f))
            .build()
    )

    Image(
        painter,
        contentDescription = it.name,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .height(80.dp)
            .width(60.dp)
    )
}


@Composable
private fun BookContentRight(it: BookEntity) {
    Row(modifier = Modifier.padding(start = 10.dp)) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            //书名
            Text(
                text = it.name,
                fontSize = 14.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.padding(top = 10.dp)
            )

            //作者
            Text(
                text = it.author,
                fontSize = 12.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = Color.Gray
            )

            //章节
            Text(
                text = it.chapter,
                fontSize = 12.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = Color.Gray
            )
        }

    }
}


