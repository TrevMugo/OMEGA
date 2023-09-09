package com.example.omega.ui.theme.pages.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.omega.R
import com.example.omega.navigation.ABOUTAPP
import com.example.omega.navigation.INVENTORY
import com.example.omega.navigation.ROUTE_LOGIN
import com.example.omega.navigation.ROUTE_SIGNUP
import com.example.omega.ui.theme.OmegaTheme

@Composable
fun HomeScreen(navController:NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.splashb),
            contentDescription ="Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement =Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,) {

        Icon(
            painter = painterResource(id = R.drawable.omega),
            contentDescription =null,
            Modifier.size(80.dp),
            tint = Color.Red
        )

        Text(
            text = "OMEGA",
            color = Color.Red,
            fontSize = 40.sp,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Home Screen",
            color =Color.Cyan,
            fontSize = 25.sp,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))





        Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {navController.navigate(ROUTE_LOGIN)},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Red),
            ) {
                Text(text = "LOGIN",
                color = Color.White,
                fontSize = 20.sp,
                modifier =  Modifier.padding()) }



            Spacer(modifier = Modifier.height(20.dp))



            Button(
                onClick = {navController.navigate(ROUTE_SIGNUP)},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Red),

            ) { Text(text = "SIGNUP",
                color = Color.White,
                fontSize = 20.sp,) }








        Spacer(modifier = Modifier.height(300.dp))


        Row(verticalAlignment = Alignment.CenterVertically) {
            TextButton(onClick = {navController.navigate(INVENTORY)}) {
                Text(text = "To other pages", color = Color.Red)
            }
        }


        Spacer(modifier = Modifier.height(15.dp))



Row(verticalAlignment = Alignment.CenterVertically) {
    Text(
        text = "About the App.",
        color =Color.Cyan,
        fontFamily = FontFamily.SansSerif,)
    TextButton(onClick = {navController.navigate(ABOUTAPP)}) {
        Text(text = "Learn More", color = Color.Red) }
}

    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    OmegaTheme {
        HomeScreen(rememberNavController())
    }
}