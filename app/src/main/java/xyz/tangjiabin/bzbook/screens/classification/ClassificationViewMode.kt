package xyz.tangjiabin.bzbook.screens.classification


import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import xyz.tangjiabin.bzbook.database.entity.BookEntity
import xyz.tangjiabin.bzbook.database.entity.SourceEntity
import xyz.tangjiabin.bzbook.database.entity.TypeEntity
import xyz.tangjiabin.bzbook.database.repository.Repository
import javax.inject.Inject

/**
 * 分类
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-29
 */
@HiltViewModel
class ClassificationViewMode @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _sourceList = mutableStateOf(
        listOf(
            SourceEntity(1, "笔趣阁"),
            SourceEntity(2, "笔下文学"),
            SourceEntity(3, "起点中文网"),
            SourceEntity(4, "红袖添香"),
            SourceEntity(5, "七猫免费小说"),
            SourceEntity(6, "书旗小说")
        )
    )

    private val _typeList = mutableStateOf(
        listOf(
            TypeEntity(1, "玄幻奇幻"),
            TypeEntity(2, "武侠仙侠"),
            TypeEntity(3, "都市体育"),
            TypeEntity(4, "历史军事"),
            TypeEntity(5, "科幻悬疑"),
            TypeEntity(6, "游戏同人"),
            TypeEntity(7, "女生频道"),
            TypeEntity(8, "其他"),
        )
    )

    private val _bookList = mutableStateOf(
        listOf(
            BookEntity(1, "书籍名称1", "https://picsum.photos/200/300?random=1", "第一千三百七十二章"),
            BookEntity(2, "书籍名称2", "https://picsum.photos/200/300?random=2", "第一千三百七十二章"),
            BookEntity(3, "书籍名称3", "https://picsum.photos/200/300?random=3", "第一千三百七十二章"),
            BookEntity(4, "书籍名称4", "https://picsum.photos/200/300?random=4", "第一千三百七十二章"),
            BookEntity(5, "书籍名称5", "https://picsum.photos/200/300?random=5", "第一千三百七十二章"),
            BookEntity(6, "书籍名称6", "https://picsum.photos/200/300?random=6", "第一千三百七十二章"),
            BookEntity(7, "书籍名称7", "https://picsum.photos/200/300?random=7", "第一千三百七十二章"),
            BookEntity(8, "书籍名称8", "https://picsum.photos/200/300?random=8", "第一千三百七十二章"),
            BookEntity(9, "书籍名称9", "https://picsum.photos/200/300?random=9", "第一千三百七十二章"),
            BookEntity(10, "书籍名称10", "https://picsum.photos/200/300?random=10", "第一千三百七十二章"),
            BookEntity(11, "书籍名称11", "https://picsum.photos/200/300?random=11", "第一千三百七十二章"),
            BookEntity(12, "书籍名称12", "https://picsum.photos/200/300?random=12", "第一千三百七十二章"),
        ))

    //类型
    val typeList: State<List<TypeEntity>> = _typeList
    var selectType: MutableState<TypeEntity> = mutableStateOf(typeList.value[0])

    //来源
    val sourceList: State<List<SourceEntity>> = _sourceList
    val selectSource: MutableState<SourceEntity> = mutableStateOf(sourceList.value[0])

    //书籍列表
    var bookList by mutableStateOf(emptyList<BookEntity>())

    fun findPage() {
        bookList = _bookList.value
    }

}
