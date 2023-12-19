package com.example.kar_inn.ui.theme.booking

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kar_inn.data.ProductViewModel
import com.example.kar_inn.navigation.ROUTE_CONTACT

@RequiresApi(Build.VERSION_CODES.N)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(controller: NavHostController) {
    val context= LocalContext.current

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier= Modifier.background(Color.White),)
    {
        Text(
            text = "BOOKING",
            color = Color(0xFFFF9800),
            modifier = Modifier.padding(16.dp),
            fontFamily = FontFamily.Serif,
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(30.dp))

        // Form
        var name by remember { mutableStateOf("") }
        var idNumber by remember { mutableStateOf("") }
        var type by remember { mutableStateOf("") }
        var quantity by remember { mutableStateOf("") }
        var date by remember { mutableStateOf("") }



        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        TextField(
            value = idNumber,
            onValueChange = { idNumber = it },
            label = { Text("ID Number") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )


        TextField(
            value = type,
            onValueChange = { type = it },
            label = { Text("Type") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )


        TextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Quantity") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )


        TextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Date (DD/MM/YYYY)") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                //-----------WRITE THE SAVE LOGIC HERE---------------//
                var productRepository = ProductViewModel(controller, context)
                productRepository.saveProduct(
                    name.trim(),
                    idNumber.trim(),
                    type.trim(),
                    quantity.trim(),
                    date)
                controller.navigate(ROUTE_CONTACT)


            },
            modifier = Modifier
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(Color.Black),
        )
        {
            Text(
                text = " DONE",
                color = Color.White
            )


        }
    }




}



@RequiresApi(Build.VERSION_CODES.N)
@Preview
@Composable
fun BookingScreenPreview() {
    BookingScreen(rememberNavController())

}

