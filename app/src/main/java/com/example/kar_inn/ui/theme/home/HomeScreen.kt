package com.example.kar_inn.ui.theme.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kar_inn.R
import com.example.kar_inn.navigation.ROUTE_ABOUT
import com.example.kar_inn.navigation.ROUTE_CONTACT
import com.example.kar_inn.navigation.ROUTE_ELECTRIC
import com.example.kar_inn.navigation.ROUTE_HOME
import com.example.kar_inn.navigation.ROUTE_SEDAN
import com.example.kar_inn.navigation.ROUTE_SUV


@Composable
fun HomeScreen(controller: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Your HomeScreen content goes here

        Surface(
            color= Color.Transparent,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                NavigationItem(
                    text = "HOME",
                    route = ROUTE_HOME,
                    controller = controller
                )

                NavigationItem(
                    text = "ABOUT US",
                    route = ROUTE_ABOUT,
                    controller = controller
                )

                NavigationItem(
                    text = "CONTACT US",
                    route = ROUTE_CONTACT,
                    controller = controller
                )
            }
        }
        Text(
            text = "KAR-INN",
            modifier= Modifier,
            color = Color(0xFFFF9800),
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 40.sp
        )
        HorizontalImageScroll(listOf(R.drawable.electric,R.drawable.sedan2,R.drawable.cycle))


        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "SUV ",
            modifier = Modifier.padding(16.dp),
            color = Color(0xFFFF9800),
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Text(
            text = "Embark on an adrenaline-fueled adventure with our premium mountain SUV'S for hire. Conquer rugged trails and embrace the thrill of nature as you navigate" +
                    " through challenging terrains.",
            modifier = Modifier,
            color = Color(0xFF000000),
            fontFamily = FontFamily.Serif,
            fontSize = 15.sp
        )

        Button(
            onClick = {
                controller.navigate(ROUTE_SUV)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.White)
        )
        {
            Text(
                text = "VIEW",
                color = Color(0xFFFF9800),
                fontWeight = FontWeight.Bold

            )

        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "ELECTRIC ",
            modifier = Modifier.padding(16.dp),
            color = Color(0xFFFF9800),
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )


        Text(
            text = "Experience the heartbeat of the city on our modern electric vehicles, available for rent. Designed for urban explorers, our electric option offers a smooth and stylish " +
                    "ride through bustling streets and scenic pathways",
            modifier = Modifier,
            color = Color(0xFF000000),
            fontFamily = FontFamily.Serif,
            fontSize = 15.sp
        )

        Button(
            onClick = {
                controller.navigate(ROUTE_ELECTRIC)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.White)
        )
        {
            Text(
                text = "VIEW",
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFF9800),
            )

        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "SEDAN ",
            modifier = Modifier.padding(16.dp),
            color = Color(0xFFFF9800),
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Text(
            text = "Engineered with safety and fun in mind, our sedan cars.Providing both casual and stylish transport for everyday " +
                    " adventures",
            modifier = Modifier,
            color = Color(0xFF000000),
            fontFamily = FontFamily.Serif,
            fontSize = 15.sp
        )

        Button(
            onClick = {
                controller.navigate(ROUTE_SEDAN)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.White)
        )
        {
            Text(
                text = "VIEW",
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFF9800),
            )

        }

        Text(
            text = "Ride with KAR-INN: Where Wheels Meet Wonders",
            color = Color(0xFF000000),
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp
        )


    }
}

@Composable
private fun NavigationItem(text: String, route: String, controller: NavHostController) {
    Text(
        text = text,
        color = Color(0xFF090808),
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                controller.navigate(route)
            }
    )
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
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())

}

