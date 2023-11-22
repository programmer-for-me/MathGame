package com.example.mathgamebysam

import android.content.Context
import android.content.SharedPreferences
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
import androidx.compose.ui.platform.LocalContext
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
            text = questions.getQuestion(id)
        )
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            var options = questions.getOptions(id)
            var option1 = options[0]
            var option2 = options[1]
            var option3 = options[2]
            var option4 = options[3]
            val context = LocalContext.current // Get the Context using LocalContext
            val sharedPreferences = remember {
                context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            }
            Button(
                onClick = {
                    if (id >= questions.questions.size) {
                        questions.saveRecordToSharedPreference(sharedPreferences, sign, score)
                        navController.navigate("main_screen")
                    }
                    if (questions.checkAnswer(id, option1))
                        score ++
                    id ++
                }
            ) {
                Text(text = "$option1")
            }
            Button(
                onClick = {
                    if (id >= questions.questions.size) {
                        questions.saveRecordToSharedPreference(sharedPreferences, sign, score)
                        navController.navigate("main_screen")
                    }
                    if (questions.checkAnswer(id, option2))
                        score ++
                    id ++
                }
            ) {
                Text(text = "$option2")
            }
            Button(
                onClick = {
                    if (id >= questions.questions.size) {
                        questions.saveRecordToSharedPreference(sharedPreferences, sign, score)
                        navController.navigate("main_screen")
                    }
                    if (questions.checkAnswer(id, option3))
                        score ++
                    id ++
                }
            ) {
                Text(text = "$option3")
            }
            Button(
                onClick = {
                    if (id >= questions.questions.size) {
                        questions.saveRecordToSharedPreference(sharedPreferences, sign, score)
                        navController.navigate("main_screen")
                    }
                    if (questions.checkAnswer(id, option4))
                        score ++
                    id ++
                }
            ) {
                Text(text = "$option4")
            }
        }
    }
}

@Preview
@Composable
private fun QuestionsScreenPreview() {
    val navController = rememberNavController()
    NavGraph(navController = navController)
    SignsScreen(navController = navController)
}