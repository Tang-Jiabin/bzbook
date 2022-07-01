package xyz.tangjiabin.bzbook.database.dao

import androidx.paging.PagingSource
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import xyz.tangjiabin.bzbook.database.entity.BookEntity

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
    fun findPage(): PagingSource<Int, BookEntity>

    @Query("SELECT * FROM bz_bookshelf")
    fun findAll(): Flow<List<BookEntity>>

    @Insert
    fun save(bookshelf: BookEntity)

    @Update
    fun update(bookshelf: BookEntity)

    @Delete
    fun delete(bookshelf: BookEntity)

    @Delete
    fun deleteAll(bookshelfList: List<BookEntity>)
}