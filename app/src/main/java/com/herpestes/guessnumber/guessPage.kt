package com.herpestes.guessnumber.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random

@Composable
fun guessPage(navController: NavController) {
    val tfGuess = remember { mutableStateOf("") }
    val kalanHak = remember { mutableStateOf(5) }
    val redirect = remember { mutableStateOf("") }
    val randomNUmber = remember { mutableStateOf(0) }
    LaunchedEffect(key1 = true){
        randomNUmber.value = Random.nextInt(101) //0-100

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            text = "Left: ${kalanHak.value}",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )
        Text(text = "Yardım: Arttır", fontSize = 24.sp)
        TextField(
            value = tfGuess.value,
            onValueChange = { tfGuess.value = it },
            label = { Text(text = "Guess") })
        Button(onClick = {
            kalanHak.value = kalanHak.value - 1
            val guess = tfGuess.value.toInt()

            if (guess==randomNUmber.value){
                navController.navigate("resultPage/true"){
                    popUpTo("guessPage"){
                        inclusive = true
                    }
                }
                return@Button
            }
            if (guess>randomNUmber.value){
                redirect.value = "Azalt"
            }
            if (guess<randomNUmber.value){
                redirect.value = "Arttır"
            }
            if (kalanHak.value == 0){
                navController.navigate("resultPage/false"){
                    popUpTo("guessPage"){
                        inclusive = true
                    }
                }
                tfGuess.value = ""
            }




                         }
            , modifier = Modifier.size(width = 250.dp, height = 50.dp)) {
            Text(text = "Guess")
        }
    }
}