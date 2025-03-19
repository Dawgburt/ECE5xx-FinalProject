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
import androidx.lifecycle.viewmodel.compose.viewModel
import ece5xx.joint.project.app_Nick_A_Phil_N.ui.theme.ECE_544x558_Final_Project_AppTheme
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Set content and initialize viewModel within the setContent block
        setContent {
            val userViewModel: UserViewModel = viewModel() // Initialize viewModel here

            // Initialize the navController and pass the ViewModel to the SetupNavGraph
            navController = rememberNavController()

            ECE_544x558_Final_Project_AppTheme {
                SetupNavGraph(navController = navController, userViewModel = userViewModel)
            }
        }
    }
}




