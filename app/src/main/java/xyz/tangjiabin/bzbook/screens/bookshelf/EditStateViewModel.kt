package xyz.tangjiabin.bzbook.screens.bookshelf

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

/**
 * 顶部
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-23
 */
class EditStateViewModel : ViewModel() {


    //书架编辑按钮
    private val _editButtonState: MutableState<EditButtonStateEnum> = mutableStateOf(value = EditButtonStateEnum.CLOSED)

    val editButtonState: State<EditButtonStateEnum> = _editButtonState
    fun updateEditButtonState(newValue: EditButtonStateEnum) {
        _editButtonState.value = newValue
    }

}