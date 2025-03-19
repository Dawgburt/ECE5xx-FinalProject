package ece5xx.joint.project.app_Nick_A_Phil_N

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ){  //Navigation Graph
        composable(
            route = Screen.LoginScreen.route
        ){
            LoginScreen(navController = navController)
        }
        composable(
            route = Screen.AddUserScreen.route
        ){
            AddUserScreen(navController = navController)
        }
        composable(
            route = Screen.SendPINandLockStatusScreen.route
        ){  backStackEntry ->
            //Get Username and Password from the route arguments
            val username = backStackEntry.arguments?.getString("username") ?: ""
            val password = backStackEntry.arguments?.getString("password") ?: ""
            SendPINandLockStatusScreen(navController = navController, username = username, password = password)
        }
        composable(
            route = Screen.LoginCheckDBSplashScreen.route
        ){  backStackEntry ->
            //Get Username and Password from the route arguments
            val username = backStackEntry.arguments?.getString("username") ?: ""
            val password = backStackEntry.arguments?.getString("password") ?: ""
            LoginCheckDBSplashScreen(navController = navController, username = username, password = password)
        }
        composable(
            route = Screen.AddUserCheckDBSplashScreen.route
        ){  backStackEntry ->
            //Get Username and Password and PIN from the route arguments
            val username = backStackEntry.arguments?.getString("username") ?: ""
            val password = backStackEntry.arguments?.getString("password") ?: ""
            val PIN = backStackEntry.arguments?.getString("PIN") ?: ""
            AddUserCheckDBSplashScreen(navController = navController, username = username, password = password, PIN = PIN)
        }
    }
}

