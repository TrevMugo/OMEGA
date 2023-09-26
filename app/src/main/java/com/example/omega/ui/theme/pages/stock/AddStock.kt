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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import com.example.omega.data.ProductRepository
import com.example.omega.R
import com.example.omega.navigation.INVENTORY
import com.example.omega.ui.theme.OmegaTheme
import androidx.compose.material3.Icon as Icon
import androidx.compose.material3.Text as Text1

@OptIn(ExperimentalMaterial3Api::class)
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
    val lightOrange = Color(0xFFFF9800)


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current

        Icon(painter = painterResource(id = R.drawable.omega),
            null,Modifier.size(80.dp),
            tint = Color.Red)
        Text1(
            text = "OMEGA",
            color = Color.Red,
            fontSize = 40.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text1(text = "Add Product(s)",
            color = Color.Cyan,
            fontFamily = FontFamily.Monospace,
            fontSize = 30.sp,)

        Spacer(modifier = Modifier.height(10.dp))


        var productName by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = productName,
            onValueChange = {productName = it},
            label = { Text(text = "Product Name")},
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = lightOrange,
                focusedIndicatorColor = lightOrange,
                unfocusedLeadingIconColor = lightOrange,
                focusedLeadingIconColor = lightOrange,
                unfocusedLabelColor = lightOrange,
                focusedLabelColor = lightOrange,
                containerColor = Color.Transparent),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Email Icon")
            },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text1(text = "Please Enter Product Name") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),)
        Spacer(modifier = Modifier.height(20.dp))

        var productQuantity by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = productQuantity,
            onValueChange = {productQuantity = it},
            label = { Text(text = "Product Quantity")},
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = lightOrange,
                focusedIndicatorColor = lightOrange,
                unfocusedLeadingIconColor = lightOrange,
                focusedLeadingIconColor = lightOrange,
                unfocusedLabelColor = lightOrange,
                focusedLabelColor = lightOrange,
                containerColor = Color.Transparent),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Email Icon")
            },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text1(text = "Please enter Product quantity") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),)
        Spacer(modifier = Modifier.height(20.dp))

        var productPrice by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = productPrice,
            onValueChange = {productPrice = it},
            label = { Text(text = "Product Price")},
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = lightOrange,
                focusedIndicatorColor = lightOrange,
                unfocusedLeadingIconColor = lightOrange,
                focusedLeadingIconColor = lightOrange,
                unfocusedLabelColor = lightOrange,
                focusedLabelColor = lightOrange,
                containerColor = Color.Transparent),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Email Icon")
            },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text1(text = "please Enter Product Price") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),)
        Spacer(modifier = Modifier.height(20.dp))

        Divider(
            color = Color.White,
            thickness = 2.dp,
            modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(20.dp))


        Button(
            onClick = {
                var productRepository = ProductRepository(navController, context)
                productRepository.saveProduct(productName.text.trim(),productQuantity.text.trim(),
                    productPrice.text)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Red)
        ) {
            Text1(
                text = "SAVE PRODUCT",
                color = Color.White,
                modifier = Modifier.padding(vertical = 10.dp))
        }
        Spacer(modifier = Modifier.height(20.dp))

        Divider(
            color = Color.White,
            thickness = 2.dp,
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {navController.navigate(INVENTORY)},
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "BACK",
                color = Color.Red,
                modifier = Modifier.padding(vertical = 10.dp)

            )
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