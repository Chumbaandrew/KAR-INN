package com.example.kar_inn.ui.theme.sedan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kar_inn.R
import com.example.kar_inn.navigation.ROUTE_BOOKING

@Composable
fun SedanScreen(controller: NavHostController) {
    Column(
        modifier= Modifier
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
    )
    {
        Text(
            text = "KIDS BIKES",

            color = Color(0xFFFF9800),
            modifier = Modifier.padding(16.dp),
            fontFamily = FontFamily.Serif,
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(10.dp))

        HorizontalImageScroll(
            listOf(
                R.drawable.sedan,
                R.drawable.sedan2,
                R.drawable.sedan3
            )
        )


        Text(
            text = "SEDAN CARS ",
            modifier = Modifier.padding(16.dp),
            color = Color(0xFFFF9800),
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp
        )

        Text(
            text = "Engineered with safety and fun in mind, our sedan cars.Providing both casual and stylish transport for everyday," +
                    " adventures",
            modifier = Modifier.padding(16.dp),
            color = Color(0xFF000000),
            fontFamily = FontFamily.Serif,
            fontSize = 15.sp
        )

        Text(
            text = "PRICE : KSH 3000 per Hour ",
            modifier = Modifier.padding(16.dp),
            color = Color(0xFFFF9800),
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp
        )

        Button(
            onClick = {
                controller.navigate(ROUTE_BOOKING)

            },
            colors = ButtonDefaults.buttonColors(Color.Black),
            modifier = Modifier.padding(50.dp)
        )
        {
            Text(
                text = " BOOK :)",
                color = Color.White
            )


        }




    }

}

@Composable
fun HorizontalImageScroll(imageList: List<Int>) {
    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        items(imageList) { imageResId ->
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun SedanPreview() {
    SedanScreen(rememberNavController())

}