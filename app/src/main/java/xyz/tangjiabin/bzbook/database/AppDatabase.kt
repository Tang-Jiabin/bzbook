package xyz.tangjiabin.bzbook.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import xyz.tangjiabin.bzbook.database.dao.BookshelfDao
import xyz.tangjiabin.bzbook.database.entity.Bookshelf
import xyz.tangjiabin.bzbook.utils.DATABASE_NAME

/**
 * appDatabase
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-28
 */
@Database(entities = [Bookshelf::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase(){

    abstract fun bookshelfDao(): BookshelfDao


}