package xyz.tangjiabin.bzbook.database.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData

import kotlinx.coroutines.flow.Flow
import xyz.tangjiabin.bzbook.database.AppDatabase
import xyz.tangjiabin.bzbook.database.entity.Bookshelf
import xyz.tangjiabin.bzbook.utils.ITEMS_PER_PAGE
import javax.inject.Inject


class Repository @Inject constructor(
    private val appDatabase: AppDatabase
) {

    fun getAllImages(): Flow<PagingData<Bookshelf>> {
        val pagingSourceFactory = { appDatabase.bookshelfDao().findAll() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
//            remoteMediator = UnsplashRemoteMediator(
//                unsplashApi = unsplashApi,
//                unsplashDatabase = unsplashDatabase
//            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    fun save() {
        val cover = "https://tva4.sinaimg.cn/large/0072Vf1pgy1foxkieg2ntj31kw0w07su.jpg"
        val bookshelf = Bookshelf(0, "书籍名称", cover, "章节")
        appDatabase.bookshelfDao().save( bookshelf)
    }

}