package com.example.omega.ui.theme.pages.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.omega.R
import com.example.omega.navigation.ROUTE_HOME
import com.example.omega.ui.theme.OmegaTheme

@Composable
fun SignUpScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.wallpaper1),
            contentDescription ="Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Signup Screen",
            color = Color.White,
            fontSize = 30.sp,
            textDecoration = TextDecoration.Underline,
            )
Spacer(modifier = Modifier.height(300.dp))

Row(verticalAlignment = Alignment.CenterVertically) {
    Text(text ="Nothing to see here.", color = Color.Cyan, fontSize = 20.sp)
    TextButton(onClick = {navController.navigate(ROUTE_HOME)}) {
        Text(text = "Back to Home", fontSize = 20.sp)
        
    }
}



    }










}





@Preview
@Composable
fun SignUpScreenPreview() {
    OmegaTheme {
        SignUpScreen(rememberNavController())
    }
}