package com.example.mathgamebysam.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mathgamebysam.MainScreen
import com.example.mathgamebysam.QuestionsScreen
import com.example.mathgamebysam.QuizApp
import com.example.mathgamebysam.SignsScreen
import com.example.mathgamebysam.SplashScreen

@Composable
fun NavGraph (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route)
    {
        composable(route = Screens.Splash.route){
            SplashScreen(navController)
        }
        composable(route = Screens.Main.route){
            MainScreen(navController)
        }
        composable(route = Screens.Questions.route){
            QuestionsScreen(navController)
        }
        composable(route = Screens.Signs.route){
            SignsScreen(navController)
        }
    }
}