package xyz.tangjiabin.bzbook.database.dao

import androidx.paging.PagingSource
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import xyz.tangjiabin.bzbook.database.entity.BookshelfEntity

/**
 * 书架
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-28
 */
@Dao
interface BookshelfDao {

    @Query("SELECT * FROM bz_bookshelf")
    fun findPage(): PagingSource<Int, BookshelfEntity>

    @Query("SELECT * FROM bz_bookshelf")
    fun findAll(): Flow<List<BookshelfEntity>>

    @Insert
    fun save(bookshelf: BookshelfEntity)

    @Update
    fun update(bookshelf: BookshelfEntity)

    @Delete
    fun delete(bookshelf: BookshelfEntity)

    @Delete
    fun deleteAll(bookshelfList: List<BookshelfEntity>)
}