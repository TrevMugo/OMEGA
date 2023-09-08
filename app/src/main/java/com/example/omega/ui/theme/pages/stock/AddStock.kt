package com.example.omega.ui.theme.pages.stock

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.example.omega.navigation.INVENTORY
import com.example.omega.ui.theme.OmegaTheme

@Composable
fun AddStock(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.splashb),
            contentDescription ="Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,) {

        Icon(
            painter = painterResource(id = R.drawable.omega),
            contentDescription = null,
            Modifier.size(80.dp),
            tint = Color.Red
        )

        Text(
            text = "OMEGA",
            color = Color.Red,
            fontSize = 40.sp,
        )

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Add Stock(s) Page",
            color = Color.Cyan,
            fontSize = 40.sp,
            textDecoration = TextDecoration.Underline
        )

        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {navController.navigate(INVENTORY) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Red),) {
            Text(text = "Back",
                color = Color.White,
                fontSize = 20.sp,
                modifier =  Modifier.padding())
        }

    }
}

@Preview
@Composable
fun AddStockPreview() {
    OmegaTheme {
        AddStock(rememberNavController())
    }
}