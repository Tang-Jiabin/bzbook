package xyz.tangjiabin.bzbook.screens.classification

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import xyz.tangjiabin.bzbook.data.SearchWidgetState
import xyz.tangjiabin.bzbook.data.TopBarViewModel
import xyz.tangjiabin.bzbook.screens.top.TopBarScreen

/**
 * 分类
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-23
 */

@Composable
fun ClassificationScreen(name: String, onClick: () -> Unit) {
    val topBarViewModel: TopBarViewModel = viewModel()
    val searchWidgetState by topBarViewModel.searchWidgetState
    val searchTextState by topBarViewModel.searchTextState

    Scaffold(

        content = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.clickable { onClick() },
                    text = name,
                    fontSize = MaterialTheme.typography.h3.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    )
}