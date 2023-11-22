package com.example.mathgamebysam.model

import kotlin.random.Random

class Questions {
    var questions = mutableListOf<Pair<String, Int>>()
    var answer = 0
    fun generateQuestions(sign: String) {
        var num1 = Random.nextInt(-50, 50)
        var num2 = Random.nextInt(-50, 50)
        answer = when (sign) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> num1 / num2
            else -> num1 + num2
        }
        questions.add(Pair("What is $num1 $sign $num2?", answer))
    }
    fun getQuestion(id: Int) : String {
        return questions[id].first
    }
    fun getOptions(id: Int) : MutableList<Int> {
        var options = mutableListOf<Int>(
            questions[id].second
        )
        options.add(questions[id].second + 2)
        options.add(questions[id].second + 5)
        options.add(questions[id].second - 3)
        options.shuffle()
        return options
    }
    fun checkAnswer(id: Int, ans: Int) : Boolean {
        if (questions[id].second == ans)
            return true
        return false
    }
}