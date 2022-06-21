package xyz.tangjiabin.bzbook.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

/**
 * 数据模型
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-21
 */
class BZViewModel : ViewModel() {

    var selectedTab = mutableStateOf(0)
    var darkTheme = mutableStateOf(false)
    var books = mutableStateOf(
        listOf(
            Book("名称1", "作者1", "封面1","简介1","连载中","143万字","第一千四百章 xxx"),
            Book("名称2", "作者2", "封面2","简介2","完结","143万字","第一千四百章 xxxxxxxxxxx"),
        )
    )
}
