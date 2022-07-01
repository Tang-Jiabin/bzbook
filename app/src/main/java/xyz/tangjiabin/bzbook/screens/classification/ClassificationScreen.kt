package xyz.tangjiabin.bzbook.screens.classification

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import xyz.tangjiabin.bzbook.R


/**
 * 分类
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-23
 */

@Composable
fun ClassificationScreen(
    navController: NavHostController,
    viewMode: ClassificationViewMode = hiltViewModel()
) {


    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        content = {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                content = {

                    Text(
                        text = viewMode.selectSource.value.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                    Row(
                        modifier = Modifier.clickable {

                            viewMode.sourceList.value.forEachIndexed { index, sourceEntity ->

                                if (viewMode.selectSource.value == sourceEntity) {

                                    if (index == viewMode.sourceList.value.size - 1) {
                                        viewMode.selectSource.value = viewMode.sourceList.value[0]
                                    } else {
                                        viewMode.selectSource.value = viewMode.sourceList.value[index + 1]
                                    }
                                    return@clickable
                                }
                            }
                        },
                        content = {
                            Icon(Icons.Default.Refresh, contentDescription = "换源")
                            Text(text = "换源", fontSize = 16.sp)
                        })
                }
            )


            Row(modifier = Modifier
                .fillMaxHeight(),
                content = {
                    LazyColumn(
                        modifier = Modifier.width(100.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        items(viewMode.typeList.value) {
                            var color = Color.Gray
                            var modifier = Modifier
                                .padding(6.dp)

                            if (it == viewMode.selectType.value) {
                                color = MaterialTheme.colors.onBackground
                                modifier = Modifier
                                    .border(1.dp, MaterialTheme.colors.onBackground, RoundedCornerShape(15.dp))
                                    .padding(6.dp)
                            }

                            TextButton(
                                onClick = { viewMode.selectType.value = it },
                                modifier = Modifier
                                    .fillMaxWidth(),
                                content = {
                                    Text(
                                        text = it.name,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = color,
                                        modifier = modifier,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            )
                        }
                    }
                    LazyColumn(modifier = Modifier.fillMaxWidth()) {
                        items(viewMode.bookList) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(120.dp)
                                    .padding(5.dp)
                            ) {
                                val painter = rememberAsyncImagePainter(
                                    ImageRequest.Builder(LocalContext.current)
                                        .data(it.cover)
                                        .placeholder(R.drawable.ic_baseline_menu_24)
                                        .error(R.drawable.ic_baseline_menu_24)
                                        .crossfade(true)
                                        .transformations(RoundedCornersTransformation(8f))
                                        .build()
                                )

//                                Image(
//                                    painter,
//                                    contentDescription = it.name,
//                                    contentScale = ContentScale.FillBounds,
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .height(80.dp)
//                                )
                                //书名
                                Text(
                                    text = it.name,
                                    fontSize = 15.sp,
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 1,
                                    modifier = Modifier.padding(top = 10.dp)
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
                }
            )
        }
    )
}



