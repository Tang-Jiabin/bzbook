package xyz.tangjiabin.bzbook.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import xyz.tangjiabin.bzbook.database.entity.Bookshelf

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

    @Query("SELECT * FROM Bookshelf")
    fun findAll(): PagingSource<Int, Bookshelf>

    @Insert
    fun save(bookshelf: Bookshelf)

    @Update
    fun update(bookshelf: Bookshelf)

    @Delete
    fun delete(bookshelf: Bookshelf)
}