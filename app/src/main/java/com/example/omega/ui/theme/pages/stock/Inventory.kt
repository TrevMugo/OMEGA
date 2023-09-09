package com.example.omega.ui.theme.pages.stock

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
import com.example.omega.navigation.ADD
import com.example.omega.navigation.DELETE
import com.example.omega.navigation.ROUTE_HOME
import com.example.omega.navigation.UPDATE
import com.example.omega.navigation.VIEW
import com.example.omega.ui.theme.OmegaTheme


@Composable
fun Inventory(navController: NavHostController) {
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
            text = "Inventory",
            color = Color.Cyan,
            fontSize = 25.sp,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center
        )



    Spacer(modifier = Modifier.height(50.dp))

            Button(onClick = {navController.navigate(VIEW)},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Red),) {
                Text(text = "View Stock",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier =  Modifier.padding())
            }

Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = {navController.navigate(ADD)},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Red),) {
                Text(text = "Add Stock",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier =  Modifier.padding())
            }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {navController.navigate(UPDATE) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Red),) {
            Text(text = "Update Stock",
                color = Color.White,
                fontSize = 20.sp,
                modifier =  Modifier.padding())
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {navController.navigate(DELETE)},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Red),) {
            Text(text = "Delete Stock",
                color = Color.White,
                fontSize = 20.sp,
                modifier =  Modifier.padding())
        }


        Spacer(modifier = Modifier.height(30.dp))

        Divider(
            color = Color.White,
            thickness = 2.dp,
            modifier = Modifier.padding(10.dp)
        )
Row(verticalAlignment = Alignment.CenterVertically) {
Text(text = "Nothing to see here?", color = Color.Cyan)
    TextButton(onClick = {navController.navigate(ROUTE_HOME)}) {
        Text(text = "Back to Home", color = Color.Red)
    }


}



    }
}


@Preview
@Composable
fun InventoryPreview() {
    OmegaTheme {
        Inventory(rememberNavController())
    }
}