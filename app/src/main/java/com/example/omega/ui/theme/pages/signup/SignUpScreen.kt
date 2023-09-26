package com.example.omega.ui.theme.pages.signup

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.omega.R
import com.example.omega.data.AuthRepository
import com.example.omega.navigation.ROUTE_LOGIN
import com.example.omega.ui.theme.OmegaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavHostController) {
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
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current

        Icon(painter = painterResource(id = R.drawable.omega),
            null,Modifier.size(80.dp),
            tint = Color.Red)
        Text(
            text = "OMEGA",
            color = Color.Red,
            fontSize = 40.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))


        Text(text = "Signup Here!",
            color = Color.Cyan,
            fontSize = 25.sp,
        )
        Spacer(modifier = Modifier.height(20.dp))
        val lightOrange = Color(0xFFFF9800)

        var name by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = { Text(text = "Name")},
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = lightOrange,
                focusedIndicatorColor = lightOrange,
                unfocusedLeadingIconColor = lightOrange,
                focusedLeadingIconColor = lightOrange,
                unfocusedLabelColor = lightOrange,
                focusedLabelColor = lightOrange,
                containerColor = Color.Transparent
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Email Icon")
            },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Enter Your Name")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),


            )
        Spacer(modifier = Modifier.height(20.dp))


        var email by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = lightOrange,
                focusedIndicatorColor = lightOrange,
                unfocusedLeadingIconColor = lightOrange,
                focusedLeadingIconColor = lightOrange,
                unfocusedLabelColor = lightOrange,
                focusedLabelColor = lightOrange,
                containerColor = Color.Transparent
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email Icon")
            },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Enter Your Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        )

        Spacer(modifier = Modifier.height(20.dp))

        var password by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Password")},
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = lightOrange,
                focusedIndicatorColor = lightOrange,
                unfocusedLeadingIconColor = lightOrange,
                focusedLeadingIconColor = lightOrange,
                unfocusedLabelColor = lightOrange,
                focusedLabelColor = lightOrange,
                containerColor = Color.Transparent
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription ="Password Icon")
            },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Enter Your Password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))

        Spacer(modifier = Modifier.height(20.dp))

        Divider(
            color = Color.White,
            thickness = 2.dp,
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))


        Button(
            onClick = {
                var authRepository = AuthRepository(navController, context)
                authRepository.signup(name.text.trim(), email.text.trim(), password.text.trim())
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Red)

        ) {
            Text(text = "SIGNUP", color = Color.White,modifier = Modifier.padding(vertical = 10.dp)) }
        Spacer(modifier = Modifier.height(20.dp))

        Divider(
            color = Color.White,
            thickness = 2.dp,
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Already have an account?",
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif)
            TextButton(onClick = {navController.navigate(ROUTE_LOGIN)}) {
                Text("Login",
                    color = Color.Cyan,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif)
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
