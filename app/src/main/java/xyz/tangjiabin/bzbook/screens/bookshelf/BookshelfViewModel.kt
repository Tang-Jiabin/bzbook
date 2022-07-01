package xyz.tangjiabin.bzbook.screens.bookshelf

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import xyz.tangjiabin.bzbook.database.entity.BookEntity
import xyz.tangjiabin.bzbook.database.repository.Repository
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

    var bookList by mutableStateOf(emptyList<BookEntity>())

    val delBookList= mutableStateListOf<BookEntity>()



    //添加书籍到书架
    fun addBookshelf(bookshelf: BookEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.addBookshelf(bookshelf)
    }


    //获取书架所有
    fun getAllBook() = viewModelScope.launch(Dispatchers.IO) {
        repository.findAllBookshelf().collect { response ->
            bookList = response
        }
    }

    fun deleteBook() = viewModelScope.launch(Dispatchers.IO) {
        repository.delBookshelf(delBookList)
        delBookList.removeAll(delBookList)
    }

    fun addDelBook(book: BookEntity) {
        delBookList.add(book)
    }

    fun removeDelBook(book: BookEntity) {
        delBookList.remove(book)
    }


}