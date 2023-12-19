package com.example.kar_inn.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kar_inn.ui.theme.about.AboutScreen
import com.example.kar_inn.ui.theme.booking.BookingScreen
import com.example.kar_inn.ui.theme.checkout.CheckOutScreen
import com.example.kar_inn.ui.theme.contact.ContactScreen
import com.example.kar_inn.ui.theme.electric.ElectricScreen
import com.example.kar_inn.ui.theme.home.HomeScreen
import com.example.kar_inn.ui.theme.index.IndexScreen
import com.example.kar_inn.ui.theme.login.LoginScreen
import com.example.kar_inn.ui.theme.motocycles.MotocycleScreen
import com.example.kar_inn.ui.theme.register.RegisterScreen
import com.example.kar_inn.ui.theme.sedan.SedanScreen
import com.example.kar_inn.ui.theme.splash.SplashScreen
import com.example.kar_inn.ui.theme.suv.SUVScreen



@Composable
fun AppNavHost(
    controller : NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SPLASH
) {

    NavHost(navController = controller,modifier= Modifier, startDestination=startDestination ) {
        composable(ROUTE_INDEX) {
            IndexScreen(controller)
        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(controller)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(controller)
        }
        composable(ROUTE_HOME) {
            HomeScreen(controller)
        }
        composable(ROUTE_SUV) {
            SUVScreen(controller)
        }
        composable(ROUTE_SEDAN) {
            SedanScreen(controller)
        }
        composable(ROUTE_ELECTRIC) {
            ElectricScreen(controller)
        }
        composable(ROUTE_BOOKING) {
            BookingScreen(controller)

        }
        composable(ROUTE_CHECK_OUT) {
            CheckOutScreen(controller)
        }
        composable(ROUTE_ABOUT) {
            AboutScreen(controller)
        }
        composable(ROUTE_CONTACT) {
            ContactScreen(controller)
        }
        composable(ROUTE_SPLASH) {
            SplashScreen(controller)
        }
        composable(ROUTE_MOTOCYCLE) {
            MotocycleScreen(controller)
        }


    }

}




