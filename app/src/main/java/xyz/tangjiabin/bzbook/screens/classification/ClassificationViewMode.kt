package xyz.tangjiabin.bzbook.screens.classification


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

import androidx.compose.runtime.State

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
                1, "男生", true,
                listOf(
                    CategoryEntity(1, "都市", true),
                    CategoryEntity(2, "玄幻", false),
                    CategoryEntity(3, "仙侠", false),
                    CategoryEntity(4, "科幻", false),
                    CategoryEntity(5, "历史", false),
                    CategoryEntity(6, "游戏", false),
                    CategoryEntity(7, "同人", false),
                    CategoryEntity(8, "社会生活", false),
                    CategoryEntity(9, "武侠", false),
                    CategoryEntity(10, "悬疑", false),
                    CategoryEntity(11, "体育", false),
                ),
            ),
            TypeEntity(
                2, "女生", false,
                listOf(
                    CategoryEntity(1, "现代言情", true),
                    CategoryEntity(2, "古代言情", false),
                    CategoryEntity(3, "玄幻言情", false),
                    CategoryEntity(4, "幻想言情", false),
                    CategoryEntity(5, "仙侠", false),
                    CategoryEntity(6, "科幻", false),
                    CategoryEntity(7, "浪漫青春", false),
                    CategoryEntity(8, "悬疑", false),
                ),
            ),
            TypeEntity(
                3, "出版", false,
                listOf(
                    CategoryEntity(1, "玄幻武侠", true),
                    CategoryEntity(2, "情感小说", false),
                    CategoryEntity(3, "成功", false),
                    CategoryEntity(4, "科幻悬疑", false),
                    CategoryEntity(5, "经济管理", false),
                    CategoryEntity(6, "生活时尚", false),
                    CategoryEntity(7, "人文社科", false),
                ),
            )
        )
    )

    //类型 男 女 出版
    val type: State<List<TypeEntity>> = _typeList


}
