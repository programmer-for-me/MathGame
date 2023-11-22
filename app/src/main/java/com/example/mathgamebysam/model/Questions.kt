package com.example.mathgamebysam.model

import android.annotation.SuppressLint
import android.content.SharedPreferences
import kotlin.random.Random

class Questions {
    var questions = mutableListOf<Pair<String, Int>>()
    fun generateQuestions(sign: String) {
        for(i in 0 .. 9) {
            var num1 = Random.nextInt(-50, 50)
            var num2 = Random.nextInt(-50, 50)
            var answer = when (sign) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> num1 / num2
                else -> num1 + num2
            }
            questions.add(Pair("What is $num1 $sign $num2?", answer))
        }
    }
    fun getQuestion(id: Int) : String {
        return questions[id].first
    }
    fun getOptions(id: Int) : MutableList<Int> {
        var options = mutableListOf(
            questions[id].second
        )
        options.add(questions[id].second + 2)
        options.add(questions[id].second + 5)
        options.add(questions[id].second - 3)
        options.shuffle()
        return options
    }
    fun checkAnswer(id: Int, ans: Int) : Boolean {
        return questions[id].second == ans
    }
    @SuppressLint("CommitPrefEdits")
    fun saveRecordToSharedPreference(sharedPreferences: SharedPreferences, sign: String, score: Int, name: String = "Player") {
        var edit = sharedPreferences.edit()
        var record = sharedPreferences.getString("sign", "Bot - 0")
        if (score >= record!!.last().toInt()) {
            edit.putString("sign", "$name - $score")
            edit.apply()
        }
    }
}