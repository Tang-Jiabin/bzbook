package xyz.tangjiabin.bzbook.ui

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import xyz.tangjiabin.bzbook.R
import xyz.tangjiabin.bzbook.data.Book

/**
 * 书架
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-21
 */

@Composable
fun Bookshelf(books: List<Book>) {

    LazyColumn (Modifier.fillMaxWidth()){
        items(books) { book ->
            Row(Modifier.fillMaxWidth()) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = "https://pic-bucket.ws.126.net/photo/0003/2021-11-16/GOTKEOOU00AJ0003NOS.jpg"
                    ),
                    contentDescription = book.name,
                    modifier = Modifier
                        .padding(4.dp)
                        .size(80.dp)
                        .border(0.3.dp, Color.Black)
                        .unread(true)
                        .clip(RoundedCornerShape(4.dp))
                )
                Column(
                    Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)) {
                    Text(text = book.name)
                    Text(text = book.chapter)
                }

            }
        }
    }
}


fun Modifier.unread(show: Boolean): Modifier = this.drawWithContent {
    drawContent()
    if (show) {
        drawCircle(Color.Red, 5.dp.toPx(), Offset(size.width - 1.dp.toPx(), 1.dp.toPx()))
    }
}



