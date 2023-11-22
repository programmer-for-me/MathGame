package com.example.mathgamebysam.navigation

sealed class Screens(val route: String) {
    object Splash: Screens("splash_screen")
    object Main: Screens("main_screen")
    object Questions: Screens("questions_screen")
    object Signs: Screens("signs_screen")
}
