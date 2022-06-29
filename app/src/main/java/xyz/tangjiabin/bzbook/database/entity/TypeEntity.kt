package xyz.tangjiabin.bzbook.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dagger.Component

/**
 * 分类
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-29
 */
@Entity
data class TypeEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val selected: Boolean,
    @ColumnInfo val categoryList: List<CategoryEntity>
)
