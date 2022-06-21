package xyz.tangjiabin.bzbook.ui

import androidx.compose.material.Icon
import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import xyz.tangjiabin.bzbook.R

/**
 * 底部导航
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-21
 */
@Composable
fun BottomBar(selected: Int, onSelectedChanged: (Int) -> Unit) {
    Row(Modifier.fillMaxWidth()) {
        TabItem(
            R.drawable.ic_baseline_library_books_24,
            "书架",
            if (selected == 0) Color.Green else Color.Black,
            Modifier
                .weight(1f)
                .clickable { onSelectedChanged(0) }
        )
        TabItem(
            R.drawable.ic_baseline_search_24,
            "搜索",
            if (selected == 1) Color.Green else Color.Black,
            Modifier
                .weight(1f)
                .clickable { onSelectedChanged(1) }
        )
        TabItem(
            R.drawable.ic_baseline_person_24,
            "我的",
            if (selected == 2) Color.Green else Color.Black,
            Modifier
                .weight(1f)
                .clickable { onSelectedChanged(2) }
        )
    }
}

@Composable
private fun TabItem(@DrawableRes iconId: Int, title: String, tint: Color, modifier: Modifier) {
    Column(
        modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(painterResource(id = iconId), title, Modifier.size(24.dp), tint)
        Text(text = title, fontSize = 11.sp, color = tint)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewBottomBar() {
    var selectTab = remember {
        mutableStateOf(1)
    }

    BottomBar(selected = 0) { selectTab.value = it }
}


