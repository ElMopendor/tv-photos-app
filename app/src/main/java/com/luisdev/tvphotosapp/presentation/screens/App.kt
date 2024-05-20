package com.luisdev.tvphotosapp.presentation.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.luisdev.tvphotosapp.presentation.screens.overview.OverviewScreen

@Composable
fun App(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "overview_screen"
    ){
        composable("overview_screen"){
            OverviewScreen()
        }

    }
}