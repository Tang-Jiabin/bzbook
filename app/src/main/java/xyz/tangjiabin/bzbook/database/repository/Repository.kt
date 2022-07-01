package xyz.tangjiabin.bzbook.database.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import xyz.tangjiabin.bzbook.database.AppDatabase
import xyz.tangjiabin.bzbook.database.entity.BookEntity
import xyz.tangjiabin.bzbook.utils.LOG_TAG_INFO
import javax.inject.Inject


class Repository @Inject constructor(
    private val appDatabase: AppDatabase
) {

    private val bookshelfDao = appDatabase.bookshelfDao()


    fun findAllBookshelf(): Flow<List<BookEntity>> {
        return bookshelfDao.findAll()
    }

    fun addBookshelf(bookshelf: BookEntity) {
        Log.d(LOG_TAG_INFO, "REPO_ADD_BOOKSHELF")
        bookshelfDao.save(bookshelf)
    }

    fun delBookshelf(delBookshelfList: MutableList<BookEntity>) {
        bookshelfDao.deleteAll(delBookshelfList)
    }


    //分页
    //    fun findPageBookshelf(): Flow<PagingData<BookshelfEntity>> {
//        val pagingSourceFactory = { appDatabase.bookshelfDao().findPage() }
//        return Pager(
//            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
//            remoteMediator = UnsplashRemoteMediator(
//                unsplashApi = unsplashApi,
//                unsplashDatabase = unsplashDatabase
//            ),
//            pagingSourceFactory = pagingSourceFactory
//        ).flow
//    }

}