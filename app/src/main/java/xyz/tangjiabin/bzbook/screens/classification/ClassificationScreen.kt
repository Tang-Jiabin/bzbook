package xyz.tangjiabin.bzbook.screens.classification

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Ro
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

/**
 * 分类
 *
 * @author J.Tang
 * @version 1.0
 * @email seven_tjb@163.com
 * @date 2022-06-23
 */

@Composable
fun ClassificationScreen(
    navController: NavHostController,
    classificationViewMode: ClassificationViewMode = hiltViewModel()
) {
    val typeList = classificationViewMode.type.value

    Column(modifier = Modifier.padding(10.dp)) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            for (typeEntity in typeList) {
                Column(Modifier.padding(10.dp).width(50.dp)) {
                    Text(text = typeEntity.name)
                    Divider(color = Color.Blue, startIndent = 10.dp,modifier = Modifier.padding(1.dp).width(25.dp).height(2.dp))
                }
            }


        }
        Row() {

            Column(modifier = Modifier.width(100.dp)) {
                for (typeEntity in typeList) {
                    if (typeEntity.selected){
                        val categoryList = typeEntity.categoryList
                        for (category in categoryList) {
                            Text(text = category.name)

                        }
                    }
                }
            }
            Column() {
                Card() {

                }
            }
        }
    }

}

