package com.example.mathgamebysam

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mathgamebysam.model.Questions
import com.example.mathgamebysam.navigation.NavGraph

@Composable
fun QuestionsScreen(navController: NavHostController) {
    var sign = "+"
    var questions = Questions()
    var score = 0
    var id = 0
    questions.generateQuestions(sign)
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Score: $score",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(700)
            )
        )
        Text(
            text = "What is 5 + 5?"
        )
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            var option1 = 0
            var option2 = 0
            var option3 = 0
            var option4 = 0
            Button(
                onClick = {

                }
            ) {
                Text(text = "10")
            }
            Button(
                onClick = {}
            ) {
                Text(text = "10")
            }
            Button(
                onClick = {}
            ) {
                Text(text = "10")
            }
            Button(
                onClick = {}
            ) {
                Text(text = "10")
            }
        }
    }
}

@Preview
@Composable
private fun TestUI() {
    val navController = rememberNavController()
    NavGraph(navController = navController)
    SignsScreen(navController = navController)
}