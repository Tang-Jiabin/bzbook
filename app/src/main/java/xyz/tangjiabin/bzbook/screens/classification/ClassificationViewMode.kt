package xyz.tangjiabin.bzbook.screens.classification


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import xyz.tangjiabin.bzbook.database.entity.CategoryEntity
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

    private val _typeList = mutableStateOf(
        listOf(
            TypeEntity(
                1, "男生",
                listOf(
                    CategoryEntity(1, "都市"),
                    CategoryEntity(2, "玄幻"),
                    CategoryEntity(3, "仙侠"),
                    CategoryEntity(4, "科幻"),
                    CategoryEntity(5, "历史"),
                    CategoryEntity(6, "游戏"),
                    CategoryEntity(7, "同人"),
                    CategoryEntity(8, "社会生活"),
                    CategoryEntity(9, "武侠"),
                    CategoryEntity(10, "悬疑"),
                    CategoryEntity(11, "体育"),
                ),
            ),
            TypeEntity(
                2, "女生",
                listOf(
                    CategoryEntity(1, "现代言情"),
                    CategoryEntity(2, "古代言情"),
                    CategoryEntity(3, "玄幻言情"),
                    CategoryEntity(4, "幻想言情"),
                    CategoryEntity(5, "仙侠"),
                    CategoryEntity(6, "科幻"),
                    CategoryEntity(7, "浪漫青春"),
                    CategoryEntity(8, "悬疑"),
                ),
            ),
            TypeEntity(
                3, "出版",
                listOf(
                    CategoryEntity(1, "玄幻武侠"),
                    CategoryEntity(2, "情感小说"),
                    CategoryEntity(3, "成功"),
                    CategoryEntity(4, "科幻悬疑"),
                    CategoryEntity(5, "经济管理"),
                    CategoryEntity(6, "生活时尚"),
                    CategoryEntity(7, "人文社科"),
                ),
            )
        )
    )

    //类型 男 女 出版
    val type: State<List<TypeEntity>> = _typeList


}
