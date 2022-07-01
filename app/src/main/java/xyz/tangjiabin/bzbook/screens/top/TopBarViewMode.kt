package xyz.tangjiabin.bzbook.screens.top

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import xyz.tangjiabin.bzbook.database.repository.Repository
import javax.inject.Inject

/**
 *
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-07-01
 */
@HiltViewModel
class TopBarViewMode @Inject constructor(
    private val repository: Repository
) : ViewModel() {


        var menuVisible by mutableStateOf(true)


}
