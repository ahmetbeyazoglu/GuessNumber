package com.herpestes.guessnumber.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun guessPage(navController: NavController) {
    val tfGuess = remember { mutableStateOf("No data") }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {
        Text(text = "Left: 5", fontSize = 36.sp, fontWeight = FontWeight.Bold, color = Color.Red)
        Text(text = "Yardım: Arttır", fontSize = 24.sp)
        TextField(value = tfGuess.value, onValueChange = {tfGuess.value = it}, label = { Text(text = "Guess") })
        Button(onClick = {

                            navController.navigate("resultPage/false"){
                                popUpTo("guessPage"){
                                    inclusive = true
                                }
                            }


                         }
            , modifier = Modifier.size(width = 250.dp, height = 50.dp)) {
            Text(text = "Guess")
        }
    }
}