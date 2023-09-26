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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.omega.R
import com.example.omega.data.ProductRepository
import com.example.omega.models.Product
import com.example.omega.navigation.UPDATE

@Composable
fun ViewStock(navController: NavHostController) {
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

        var context = LocalContext.current
        var productRepository = ProductRepository(navController, context)

        val emptyProductState = remember { mutableStateOf(Product("","","","")) }
        var emptyProductsListState = remember { mutableStateListOf<Product>() }

        var products = productRepository.viewProducts(emptyProductState, emptyProductsListState)



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
            text = "View Stock(s) Page",
            color = Color.Cyan,
            fontSize = 38.sp,
            fontFamily = FontFamily.SansSerif
        )



        Text(text = "All products",
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            color = Color.White)

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {
            items(products){
                ProductItem(
                    name = it.name,
                    quantity = it.quantity,
                    price = it.price,
                    id = it.id,
                    navController = navController,
                    productRepository = productRepository
                )
            }
        }
    }
}



@Composable
fun ProductItem(name:String, quantity:String, price:String, id:String,
                navController:NavHostController, productRepository:ProductRepository) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = quantity)
        Text(text = price)
        Row (modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically){
            Button(onClick = {
                productRepository.deleteProduct(id) },
                colors = ButtonDefaults.buttonColors(Color.Red),
            ) {
                Text(text = "DELETE", color = Color.White)
            }
            Spacer(modifier = Modifier.width(25.dp))

            Button(onClick = {
                navController.navigate(UPDATE)},
                colors = ButtonDefaults.buttonColors(Color.Red),
            ) {
                Text(text = "UPDATE", color = Color.White)
            }
        }


    }

}





