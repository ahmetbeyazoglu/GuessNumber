package com.herpestes.guessnumber

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun resultPage(navController: NavController, incomingResult: Boolean) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        if (incomingResult){
            Text(text = "Kazandınız", fontSize = 36.sp, fontWeight = FontWeight.Bold)
            Image(painter = painterResource(id = R.drawable.happy_face), contentDescription = null)
        }else{
            Text(text = "Kaybettiniz", fontSize = 36.sp, fontWeight = FontWeight.Bold)
            Image(painter = painterResource(id = R.drawable.sad_face), contentDescription = null)
        }
    }
}