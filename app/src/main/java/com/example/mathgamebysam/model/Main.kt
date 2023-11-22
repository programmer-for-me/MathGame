package com.example.mathgamebysam.model

import androidx.navigation.NavHostController

class Main {
    fun navigate(navHostController: NavHostController, id: String) {
        navHostController.navigate(id)
    }
}