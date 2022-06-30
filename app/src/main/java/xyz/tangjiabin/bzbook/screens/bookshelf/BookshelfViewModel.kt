package xyz.tangjiabin.bzbook.screens.bookshelf

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import xyz.tangjiabin.bzbook.database.entity.BookshelfEntity
import xyz.tangjiabin.bzbook.database.repository.Repository
import xyz.tangjiabin.bzbook.utils.LOG_TAG_INFO
import javax.inject.Inject

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


    //书架编辑按钮
    private val _editButtonState: MutableState<EditButtonStateEnum> = mutableStateOf(value = EditButtonStateEnum.CLOSED)

    val editButtonState: State<EditButtonStateEnum> = _editButtonState
    fun updateEditButtonState(newValue: EditButtonStateEnum) {
        _editButtonState.value = newValue
    }

    var bookshelfList by mutableStateOf(emptyList<BookshelfEntity>())

    val delBookshelfList= mutableStateListOf<BookshelfEntity>()



    //添加书籍到书架
    fun addBookshelf(bookshelf: BookshelfEntity) = viewModelScope.launch(Dispatchers.IO) {
        Log.d(LOG_TAG_INFO, "VIEW_MODE_ADD_BOOKSHELF")
        repository.addBookshelf(bookshelf)

    }


    //获取书架所有
    fun getAllBookshelf() = viewModelScope.launch(Dispatchers.IO) {
        repository.findAllBookshelf().collect { response ->
            bookshelfList = response
        }
    }

    fun deleteBookshelf() = viewModelScope.launch(Dispatchers.IO) {
        for (bookshelfEntity in delBookshelfList) {
            Log.d(LOG_TAG_INFO, bookshelfEntity.toString())
        }
        repository.delBookshelf(delBookshelfList)
        delBookshelfList.removeAll(delBookshelfList)
        for (bookshelfEntity in delBookshelfList) {
            Log.d(LOG_TAG_INFO, bookshelfEntity.toString())
        }
    }

    fun addDelBookshelf(book: BookshelfEntity) {
        delBookshelfList.add(book)
    }

    fun removeDelBookshelf(book: BookshelfEntity) {
        delBookshelfList.remove(book)
    }


}