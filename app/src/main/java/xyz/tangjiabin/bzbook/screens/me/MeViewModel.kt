package xyz.tangjiabin.bzbook.screens.me

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
 * @date 2022-07-06
 */
@HiltViewModel
class MeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {


}
