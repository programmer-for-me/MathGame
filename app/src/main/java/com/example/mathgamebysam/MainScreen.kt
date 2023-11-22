package com.example.mathgamebysam

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mathgamebysam.model.Main
import com.example.mathgamebysam.navigation.NavGraph
import com.example.mathgamebysam.navigation.Screens

@Composable
fun MainScreen(navController: NavHostController) {
    val main = Main()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFFD0BCFF)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                  main.navigate(navController, "signs_screen")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF3BC00)
            ),
            shape = RoundedCornerShape(20.dp),
            contentPadding = PaddingValues(20.dp)
        ) {
            Text(
                text = "NEW GAME",
                fontFamily = FontFamily(Font(R.font.lilitaone))
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF3BC00)
            ),
            shape = RoundedCornerShape(20.dp),
            contentPadding = PaddingValues(20.dp)
        ) {
            Text(
                text = "RECORDS",
                fontFamily = FontFamily(Font(R.font.lilitaone))
            )
        }
    }
}

@Preview
@Composable
private fun testUI() {
    val navController = rememberNavController()
    NavGraph(navController = navController)
    SplashScreen(navController = navController)
}