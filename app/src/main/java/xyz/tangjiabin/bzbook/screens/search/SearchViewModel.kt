package xyz.tangjiabin.bzbook.screens.search

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import xyz.tangjiabin.bzbook.database.entity.BookEntity
import xyz.tangjiabin.bzbook.database.repository.Repository
import javax.inject.Inject
import kotlin.random.Random

/**
 *
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-07-18
 */
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private var _textValue = mutableStateOf("")

    var bookList by mutableStateOf(emptyList<BookEntity>())

    val textValue: State<String> = _textValue

    private val _bookList = mutableStateOf(
        listOf(
            BookEntity(1, "书籍名称1"+ Random.nextInt(100), "作者1"+ Random.nextInt(100),"https://picsum.photos/200/300?random=1", "第一千三百七十二章"),
            BookEntity(2, "书籍名称2"+ Random.nextInt(100), "作者1"+ Random.nextInt(100),"https://picsum.photos/200/300?random=2", "第一千三百七十二章"),
            BookEntity(3, "书籍名称3"+ Random.nextInt(100), "作者1"+ Random.nextInt(100),"https://picsum.photos/200/300?random=3", "第一千三百七十二章"),
            BookEntity(4, "书籍名称4"+ Random.nextInt(100), "作者1"+ Random.nextInt(100),"https://picsum.photos/200/300?random=4", "第一千三百七十二章"),
            BookEntity(5, "书籍名称5"+ Random.nextInt(100), "作者1"+ Random.nextInt(100),"https://picsum.photos/200/300?random=5", "第一千三百七十二章"),
            BookEntity(6, "书籍名称6"+ Random.nextInt(100), "作者1"+ Random.nextInt(100),"https://picsum.photos/200/300?random=6", "第一千三百七十二章"),
            BookEntity(7, "书籍名称7"+ Random.nextInt(100), "作者1"+ Random.nextInt(100),"https://picsum.photos/200/300?random=7", "第一千三百七十二章"),
            BookEntity(8, "书籍名称8"+ Random.nextInt(100), "作者1"+ Random.nextInt(100),"https://picsum.photos/200/300?random=8", "第一千三百七十二章"),
            BookEntity(9, "书籍名称9"+ Random.nextInt(100), "作者1"+ Random.nextInt(100),"https://picsum.photos/200/300?random=9", "第一千三百七十二章"),
            BookEntity(10, "书籍名称10"+ Random.nextInt(100), "作者1"+ Random.nextInt(100),"https://picsum.photos/200/300?random=10", "第一千三百七十二章"),
            BookEntity(11, "书籍名称11"+ Random.nextInt(100), "作者1"+ Random.nextInt(100),"https://picsum.photos/200/300?random=11", "第一千三百七十二章"),
            BookEntity(12, "书籍名称12"+ Random.nextInt(100), "作者1"+ Random.nextInt(100),"https://picsum.photos/200/300?random=12", "第一千三百七十二章"),
        ))

    fun setTextValue(tv:String){
        _textValue.value = tv
    }

    fun findBook() {
        bookList = _bookList.value
    }
}