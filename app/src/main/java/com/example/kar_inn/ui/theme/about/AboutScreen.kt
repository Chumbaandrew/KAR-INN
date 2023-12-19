package com.example.kar_inn.ui.theme.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.kar_inn.navigation.ROUTE_HOME

@androidx.compose.runtime.Composable
fun AboutScreen(controller: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(
                rememberScrollState()
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        //Spacer(modifier = Modifier.height(19.dp))

        Surface(
            //color = MaterialTheme.colorScheme.primary,
            color= Color.Transparent,
//            elevation = 2.dp,
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
                // Add text for each screen in the navigation bar
                Text(
                    text = "HOME",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF090808),
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            controller.navigate(ROUTE_HOME)
                        }
                )

                Text(
                    text = "ABOUT US",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF020202),
//                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable {
                            controller.navigate(ROUTE_ABOUT)
                        }
                )
                Text(
                    text = "CONTACT US",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF020202),
//                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable {
                            controller.navigate(ROUTE_CONTACT)
                        }
                )

                // Add more text for other screens as needed
            }
        }

        Text(
            text = "ABOUT US",
            color = Color(0xFFC9B507),
            fontFamily = FontFamily.SansSerif,
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(id = R.drawable.abouticon),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .border(
                    width = 5.dp,
                    color = Color.Black,
                    shape = CircleShape
                )
        )
        Spacer(modifier = Modifier.height(30.dp))


        Text(
            text = "KARibu KARinn! We are passionate about providing exceptional car rental services to enhance your driving experience in the beautiful" +
                    " landscapes of Kenya. Our mission is to promote an active and sustainable lifestyle while exploring the wonders on automotives.",
            color = Color(0xFF070707),
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(30.dp))


        Text(
            text = "Functions\n \n" +
                    " Quality car Rentals\n \n" +
                    "At Karinn Hire Company, we offer a wide range of meticulously maintained cars suitable for different preferences and driving styles." +
                    " Whether you're into leisurely drives, mountain adventures, or casual road escapades, we have the perfect car for you.\n" +
                    "\n" +
                    "Discover the hidden gems of kenya with our curated automobiles. Our experienced team can provide insights, " +
                    "safety tips, and local knowledge to make your driving journey memorable and enjoyable.",
            color = Color(0xFF070707),
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Mission\n" +
                    "Our mission at KARinn Hire Company is to empower individuals to embrace an lavish lifestyle by providing access to high-quality vehicles and exceptional" +
                    " driving experiences. We believe in fostering a sense of adventure, promoting sustainable travel, and encouraging a strong connection with the environment " +
                    "through driving.",
            color = Color(0xFF070707),
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Location\n" +
                    "KARinn Hire Company is nestled in the heart of kenya, a region renowned for its stunning natural beauty and diverse cycling trails. " +
                    "Our strategic location allows easy access scenic routes, varying in difficulty and terrain, ensuring there's a perfect driving for everyone," +
                    " from beginners to avid drivers.",
            color = Color(0xFF070707),
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(10.dp))


        Text(
            text = "KARibu KARinn: Where Wheels Meet Wonders",
            color = Color(0xFFCDDC39),
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp
        )


    }

}
@Preview
@Composable
fun AboutPreview() {
    AboutScreen(rememberNavController())

}