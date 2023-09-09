package com.example.omega.ui.theme.pages.aboutapp

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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
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
import com.example.omega.navigation.ROUTE_HOME
import com.example.omega.ui.theme.OmegaTheme

@Composable
fun AboutApp(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.splashb),
            contentDescription ="Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize() )
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {

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

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.omega),
                contentDescription =null,
                Modifier.size(25.dp),
                tint = Color.Cyan
            )
            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = "About The App",
                color = Color.Cyan,
                fontSize = 30.sp,
                textAlign = TextAlign.Left,
                fontFamily = FontFamily.Monospace
            )
        }
        Divider(color = Color.White, thickness = 2.dp, modifier = Modifier.padding(10.dp))

        Text(
            textAlign = TextAlign.Center,
            text = "Omega is a stock management system that helps manage the inventory of micro-shops and supermarkets in the community. ",
            color = Color.Red,
            fontSize = 20.sp
        )

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.omega),
                contentDescription =null,
                Modifier.size(25.dp),
                tint = Color.Cyan
            )
            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = "The Creator",
                color = Color.Cyan,
                fontSize = 30.sp,
                textAlign = TextAlign.Left,
                fontFamily = FontFamily.Monospace
            )
        }
        Divider(color = Color.White, thickness = 2.dp, modifier = Modifier.padding(10.dp))

        Text(
            textAlign = TextAlign.Center,
            text = "The application was created by Trevor Mugo, an eMobilis Student, with some assistance from his instructor , Mr.Wanyama. ",
            color = Color.Red,
            fontSize = 20.sp
        )

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.omega),
                contentDescription =null,
                Modifier.size(25.dp),
                tint = Color.Cyan
            )
            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = "Its Aims",
                color = Color.Cyan,
                fontSize = 30.sp,
                textAlign = TextAlign.Left,
                fontFamily = FontFamily.Monospace
            )
        }
        Divider(color = Color.White, thickness = 2.dp, modifier = Modifier.padding(10.dp))

        Text(
            textAlign = TextAlign.Center,
            text = "The application is created to be able to create, view , update and delete stock present in the shop." +
                    "It will hopefully assist the targeted shops to manage their stock better",
            color = Color.Red,
            fontSize = 20.sp
        )

        Divider(color = Color.White, thickness = 2.dp, modifier = Modifier.padding(10.dp))

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Wanna go back?",
                color = Color.White,
                fontSize = 25.sp
            )
            TextButton(onClick = {navController.navigate(ROUTE_HOME)}) {
                Text(text = "Back to Home",
                    fontSize = 25.sp,
                    color = Color.Red
                )
            }



        }


    }
}

@Preview
@Composable
fun AboutAppPreview() {
    OmegaTheme {
        AboutApp(rememberNavController())
    }
}