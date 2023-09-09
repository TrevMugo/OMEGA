package com.example.omega.ui.theme.pages.login

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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.omega.R
import com.example.omega.navigation.ROUTE_HOME
import com.example.omega.navigation.ROUTE_SIGNUP
import com.example.omega.ui.theme.OmegaTheme

@Composable
fun LoginScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val passwordFocusRequester = FocusRequester()
    val focusManager = LocalFocusManager.current

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.wallpaper1),
            contentDescription ="Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }



    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(painter = painterResource(id = R.drawable.omega),
            null,Modifier.size(80.dp),
            tint = Color.Red)
        Text(
            text = "Login Here",
            color = Color.Red,
            fontSize = 25.sp,
            fontFamily = FontFamily.Monospace
        )

        Spacer(modifier = Modifier.height(20.dp))



        Spacer(modifier = Modifier.height(20.dp))

        TextInput(InputType.Name, keyboardActions = KeyboardActions (onNext = {
            passwordFocusRequester.requestFocus()
        } ))

        Spacer(modifier = Modifier.height(15.dp))

        TextInput(InputType.Password, keyboardActions = KeyboardActions(onDone = {
focusManager.clearFocus()
        }), focusRequester = passwordFocusRequester)

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {navController.navigate(ROUTE_HOME)},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Red)

            ) {
            Text(text = "LOGIN",Modifier.padding(vertical = 10.dp)) }
        Spacer(modifier = Modifier.height(15.dp))

        Divider(
            color = Color.White,
            thickness = 2.dp,
            modifier = Modifier.padding(10.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Don't have an account?", color = Color.White)
            TextButton(onClick = {navController.navigate(ROUTE_SIGNUP)}) {
                Text("SignUp!", color = Color.Red) } }

        Spacer(modifier = Modifier.height(180.dp))

        Button(
            onClick = {navController.navigate(ROUTE_HOME)},
            Modifier.width(250.dp),
            colors =ButtonDefaults.buttonColors(Color.Red)) {
            Text(text = "BACK TO HOME", Modifier.padding(vertical = 10.dp),)
        }
    }
}

sealed class InputType(
    val label:String,
    val icon:ImageVector,
    val keyboardOptions: KeyboardOptions,
    val visualTransformation: VisualTransformation,

    ){
    object Name:InputType(
        label = "Username",
        icon = Icons.Default.Person,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None)

    object Password:InputType(
        label = "Password",
        icon = Icons.Default.Lock,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done, keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation()
    )

}





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(InputType:InputType,
              focusRequester: FocusRequester? = null,
              keyboardActions: KeyboardActions
) {
    var value by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester ?: FocusRequester()),
        leadingIcon = {Icon(imageVector = InputType.icon, null)},
        label = {Text(text = InputType.label)},
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent),
        singleLine = true,
        keyboardOptions = InputType.keyboardOptions,
        visualTransformation = InputType.visualTransformation,
        keyboardActions = keyboardActions

    )
}

@Preview
@Composable
fun LoginScreenPreview() {
    OmegaTheme {
        LoginScreen(rememberNavController())
    }
}