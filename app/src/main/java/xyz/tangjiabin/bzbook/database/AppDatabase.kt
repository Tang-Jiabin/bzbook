package xyz.tangjiabin.bzbook.database

import androidx.room.Database
import androidx.room.RoomDatabase
import xyz.tangjiabin.bzbook.database.dao.BookshelfDao
import xyz.tangjiabin.bzbook.database.entity.BookshelfEntity

/**
 * appDatabase
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-28
 */
@Database(entities = [BookshelfEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun bookshelfDao(): BookshelfDao


}