package com.example.mathgamebysam.model

import androidx.navigation.NavHostController

class Signs {
    fun goto(id: String, navHostController: NavHostController) {
        navHostController.navigate(id)
    }
}