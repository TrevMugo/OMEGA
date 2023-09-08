package com.example.omega.ui.theme.pages.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.omega.R
import com.example.omega.navigation.ROUTE_HOME
import com.example.omega.ui.theme.OmegaTheme
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavHostController,modifier: Modifier = Modifier) {
LaunchedEffect(key1 = true){
    delay(2000L)
    navController.navigate(ROUTE_HOME)
}
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.splashb),
            contentDescription ="Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()

        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.omega),
            contentDescription =null,
            Modifier.size(120.dp),
            tint = Color.Red
        )

        Text(
            text = "OMEGA",
            color = Color.Red,
            fontSize = 40.sp,
        )
        Spacer(modifier = Modifier.height(200.dp))

        Text(
            text = "By : Trevor Mugo",
            color = Color.Red,
            fontSize = 20.sp
        )







    }
}


@Preview
@Composable
fun SplashPreview() {

    OmegaTheme {
        Splash(rememberNavController())

    }
}