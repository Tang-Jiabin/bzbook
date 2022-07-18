package xyz.tangjiabin.bzbook.screens.me

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import xyz.tangjiabin.bzbook.R


/**
 * 我的
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-23
 */

@Composable
fun MeScreen(navController: NavHostController, viewModel: MeViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(240, 240, 240))
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxWidth()
                .height(100.dp)


                .padding(start = 10.dp, end = 10.dp)
        ) {
            val painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data("https://picsum.photos/200/300?random=60")
                    .placeholder(R.drawable.ic_baseline_image_24)
                    .error(R.drawable.ic_baseline_image_24)
                    .crossfade(true)
                    .transformations(RoundedCornersTransformation(8f))
                    .build()
            )

            Image(
                painter,
                contentDescription = "头像",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
                    .padding(10.dp)
            )
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = "昵称",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground,
                    textAlign = TextAlign.Center
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "账号")
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                        contentDescription = "修改",
                        modifier = Modifier.size(20.dp),
                        tint = Color.LightGray
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Spacer(
                modifier = Modifier
                    .height(8.dp)
                    .fillMaxWidth()
                    .background(Color(240, 240, 240))
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(0.dp))
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
                ) {
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_storage_24),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "书源管理", modifier = Modifier
                                .background(MaterialTheme.colors.background)
                                .padding(start = 20.dp)
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                        contentDescription = "修改",
                        modifier = Modifier.size(20.dp),
                        tint = Color.LightGray
                    )
                }

            }
            Spacer(
                modifier = Modifier
                    .height(8.dp)
                    .fillMaxWidth()
                    .background(Color(240, 240, 240))
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(0.dp))
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
                ) {
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_comment_24),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "我的评论", modifier = Modifier
                                .background(MaterialTheme.colors.background)
                                .padding(start = 20.dp)
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                        contentDescription = "修改",
                        modifier = Modifier.size(20.dp),
                        tint = Color.LightGray
                    )
                }

            }
            Divider(color = Color(240, 240, 240))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(0.dp))
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
                ) {
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_mail_24),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "我的消息", modifier = Modifier
                                .background(MaterialTheme.colors.background)
                                .padding(start = 20.dp)
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                        contentDescription = "修改",
                        modifier = Modifier.size(20.dp),
                        tint = Color.LightGray
                    )
                }
            }
            Divider(color = Color(240, 240, 240))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(0.dp))
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
                ) {
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_history_24),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "阅读历史", modifier = Modifier
                                .background(MaterialTheme.colors.background)
                                .padding(start = 20.dp)
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                        contentDescription = "修改",
                        modifier = Modifier.size(20.dp),
                        tint = Color.LightGray
                    )
                }

            }

            Spacer(
                modifier = Modifier
                    .height(8.dp)
                    .fillMaxWidth()
                    .background(Color(240, 240, 240))
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(0.dp))
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
                ) {
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_settings_24),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "设置", modifier = Modifier
                                .background(MaterialTheme.colors.background)
                                .padding(start = 20.dp)
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                        contentDescription = "修改",
                        modifier = Modifier.size(20.dp),
                        tint = Color.LightGray
                    )
                }

            }
        }
    }
}