package com.herpestes.guessnumber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.herpestes.guessnumber.ui.theme.GuessNumberTheme
import com.herpestes.guessnumber.ui.theme.guessPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessNumberTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    pageRedirect()

                }
            }
        }
    }
}

@Composable
fun pageRedirect(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainPage"){
        composable("mainPage"){
            mainPage(navController)
        }
        composable("guessPage"){
            guessPage(navController)
        }
        composable("resultPage/{result}", arguments = listOf(
            navArgument("result"){ type = NavType.BoolArrayType }
        )){
            val result = it.arguments?.getBoolean("result")!!
            resultPage(navController, result)
        }

    }
}


@Composable
fun mainPage(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {
        Text(text = "Guess Game", fontSize = 36.sp, fontWeight = FontWeight.Bold)
        Image(painter = painterResource(id = R.drawable.zar_resim), contentDescription = null)
        Button(onClick = { navController.navigate("guessPage") }, modifier = Modifier.size(width = 250.dp, height = 50.dp)) {
            Text(text = "Start Game")

        }

    }

}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    GuessNumberTheme {

    }
}
