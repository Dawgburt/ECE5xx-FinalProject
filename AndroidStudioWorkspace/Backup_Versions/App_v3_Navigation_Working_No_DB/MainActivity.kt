/*
* Nick Allmeyer
* Phil Nevins
* ECE 544/558
* Winter 2025
* Final Project App
*
* Description:
*
* Credits:
*
* */

package ece5xx.joint.project.app_Nick_A_Phil_N

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ece5xx.joint.project.app_Nick_A_Phil_N.ui.theme.ECE_544x558_Final_Project_AppTheme
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ECE_544x558_Final_Project_AppTheme {

                navController = rememberNavController() //Handles back stack and state of composable screens
                SetupNavGraph(navController = navController)


                //LoginScreen() //Home Screen

                //Only here for preview purposes
                //AddUserScreen()
                //AddUserCheckDBSplashScreen()
                //LoginCheckDBSplashScreen()
                //SendPINandLockStatusScreen()
            }
        }
    }
}


