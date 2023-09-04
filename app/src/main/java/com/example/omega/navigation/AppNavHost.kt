package com.example.omega.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.omega.ui.theme.pages.home.HomeScreen
import com.example.omega.ui.theme.pages.login.LoginScreen
import com.example.omega.ui.theme.pages.signup.SignUpScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_HOME
) {
    NavHost(navController = navController,
    modifier = Modifier, startDestination = startDestination){
        composable(ROUTE_HOME){
            HomeScreen(navController)
        }

        composable(ROUTE_LOGIN){
        LoginScreen(navController)
        }

        composable(ROUTE_SIGNUP){
            SignUpScreen(navController)
        }




    }







}