package ece5xx.joint.project.app_Nick_A_Phil_N

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    userViewModel: UserViewModel // Add UserViewModel here
) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {  // Navigation Graph
        composable(
            route = Screen.LoginScreen.route
        ) {
            LoginScreen(navController = navController, userViewModel = userViewModel) // Pass UserViewModel to LoginScreen
        }
        composable(
            route = Screen.AddUserScreen.route
        ) {
            AddUserScreen(navController = navController, userViewModel = userViewModel) // Pass UserViewModel to AddUserScreen
        }
        composable(
            route = Screen.SendPINandLockStatusScreen.route
        ) { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: ""
            val password = backStackEntry.arguments?.getString("password") ?: ""
            SendPINandLockStatusScreen(
                navController = navController,
                username = username,
                password = password,
                userViewModel = userViewModel // Pass UserViewModel to SendPINandLockStatusScreen
            )
        }
        composable(
            route = Screen.LoginCheckDBSplashScreen.route
        ) { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: ""
            val password = backStackEntry.arguments?.getString("password") ?: ""
            LoginCheckDBSplashScreen(
                navController = navController,
                username = username,
                password = password,
                userViewModel = userViewModel // Pass UserViewModel to LoginCheckDBSplashScreen
            )
        }
        composable(
            route = Screen.AddUserCheckDBSplashScreen.route
        ) { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: ""
            val password = backStackEntry.arguments?.getString("password") ?: ""
            val PIN = backStackEntry.arguments?.getString("PIN") ?: ""
            AddUserCheckDBSplashScreen(
                navController = navController,
                username = username,
                password = password,
                PIN = PIN,
                userViewModel = userViewModel // Pass UserViewModel to AddUserCheckDBSplashScreen
            )
        }
    }
}



