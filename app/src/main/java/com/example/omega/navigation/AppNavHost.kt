package com.example.omega.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.omega.ui.theme.pages.aboutapp.AboutApp
import com.example.omega.ui.theme.pages.stock.Inventory
import com.example.omega.ui.theme.pages.home.HomeScreen
import com.example.omega.ui.theme.pages.login.LoginScreen
import com.example.omega.ui.theme.pages.signup.SignUpScreen
import com.example.omega.ui.theme.pages.splash.Splash
import com.example.omega.ui.theme.pages.stock.AddStock
import com.example.omega.ui.theme.pages.stock.DeleteStock
import com.example.omega.ui.theme.pages.stock.UpdateStock
import com.example.omega.ui.theme.pages.stock.ViewStock

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = SPLASH
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
        composable(SPLASH){
            Splash(navController)
        }

        composable(INVENTORY){
            Inventory(navController)

        }

        composable(VIEW){
            ViewStock(navController)
        }

        composable(ADD){
            AddStock(navController)
        }
        composable(UPDATE){
            UpdateStock(navController)
        }

        composable(DELETE){
            DeleteStock(navController)
        }

        composable(ABOUTAPP){
            AboutApp(navController)
        }


    }







}