package xyz.tangjiabin.bzbook.screens.bookshelf

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import xyz.tangjiabin.bzbook.database.entity.Bookshelf
import xyz.tangjiabin.bzbook.database.repository.Repository
import javax.inject.Inject
import kotlin.concurrent.thread

/**
 * 书架数据
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-28
 */
@HiltViewModel
class BookshelfViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {



    fun save() {
        thread(start = true) {
            Log.d("SAVE","SAVE")
            repository.save()
        }
    }

    val bk = repository.getAllImages()


}