package com.example.mathgamebysam

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mathgamebysam.model.Signs
import com.example.mathgamebysam.navigation.NavGraph

@Composable
fun GameButton(
    text: String,
    backgroundColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp)),
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = textColor,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        )
    }
}

@Composable
fun SignsScreen (navController: NavHostController){
    val signs = Signs()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GameButton(
            text = "+",
            backgroundColor = Color.Green,
            textColor = Color.White,
            onClick = {
                signs.goto("plus", navController)
            }
        )

        GameButton(
            text = "-",
            backgroundColor = Color.Blue,
            textColor = Color.White,
            onClick = {
                signs.goto("minus", navController)
            }
        )

        GameButton(
            text = "*",
            backgroundColor = Color.Magenta,
            textColor = Color.White,
            onClick = {
                signs.goto("multiply", navController)
            }
        )

        GameButton(
            text = "/",
            backgroundColor = Color.Red,
            textColor = Color.White,
            onClick = {
                signs.goto("divide", navController)
            }
        )
    }
}

@Preview
@Composable
private fun TestUI() {
    val navController = rememberNavController()
    NavGraph(navController = navController)
    SignsScreen(navController = navController)
}