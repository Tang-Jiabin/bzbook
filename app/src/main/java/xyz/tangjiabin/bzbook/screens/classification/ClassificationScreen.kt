package xyz.tangjiabin.bzbook.screens.classification

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
        ) {
            for (typeEntity in typeList) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .width(50.dp)
                        .clickable {  },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(text = typeEntity.name, modifier = Modifier.padding(2.dp))
                        Divider(
                            color = Color.Blue, modifier = Modifier
                                .padding(1.dp)
                                .width(15.dp)
                                .height(3.dp)
                        )
                }
            }

        }
        Row(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxHeight()
                .width(100.dp)
        ) {

            Column(modifier = Modifier.width(100.dp)) {
                for (typeEntity in typeList) {
                        val categoryList = typeEntity.categoryList
                        for (category in categoryList) {

                            Text(text = category.name)

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


