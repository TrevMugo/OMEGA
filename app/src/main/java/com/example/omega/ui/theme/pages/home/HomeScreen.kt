package com.example.omega.ui.theme.pages.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.omega.R
import com.example.omega.navigation.ROUTE_LOGIN
import com.example.omega.navigation.ROUTE_SIGNUP
import com.example.omega.ui.theme.OmegaTheme

@Composable
fun HomeScreen(navController:NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.wallpaper1),
            contentDescription ="Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "OMEGA",
            color =Color.Yellow,
            fontSize = 45.sp,
            fontFamily = FontFamily.SansSerif,
            textDecoration = TextDecoration.Underline,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Welcome to Home Screen",
            color =Color.White,
            fontSize = 25.sp,
            fontFamily = FontFamily.Monospace,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "What would you like to start with?",
            color =Color.Cyan,
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center
        )



        Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {navController.navigate(ROUTE_LOGIN)},
                modifier = Modifier.fillMaxWidth()
            ) { Text(text = "LOGIN") }



            Spacer(modifier = Modifier.height(20.dp))



            Button(
                onClick = {navController.navigate(ROUTE_SIGNUP)},
                modifier = Modifier.fillMaxWidth()

            ) { Text(text = "SIGNUP") }


        Spacer(modifier = Modifier.height(300.dp))

Row(verticalAlignment = Alignment.CenterVertically) {
    Text(
        text = "About the App.",
        color =Color.Cyan,
        fontFamily = FontFamily.SansSerif,)
    TextButton(onClick = {}) {
        Text(text = "Learn More") }
}

        Text(
            text = "BY : TREVOR MUGO",
            color =Color.Cyan,
            fontSize = 20.sp,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline,
        )

        Spacer(modifier = Modifier.height(20.dp))


    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    OmegaTheme {
        HomeScreen(rememberNavController())
    }
}