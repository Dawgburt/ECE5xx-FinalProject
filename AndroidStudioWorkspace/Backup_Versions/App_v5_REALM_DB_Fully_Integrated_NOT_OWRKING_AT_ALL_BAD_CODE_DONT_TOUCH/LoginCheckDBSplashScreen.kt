package ece5xx.joint.project.app_Nick_A_Phil_N

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.material3.CircularProgressIndicator
import androidx.navigation.NavController

//Login Check DataBase (DB) Splash Screen
//Indicates to User that the DataBase is being checked after Login attempt and
//if the username and password match goes to the Lock Status Screen
//else if the username and password don't match, goes back to the Login Screen
@Composable
fun LoginCheckDBSplashScreen(navController: NavController, username: String, password: String, userViewModel: UserViewModel) {
    val loadingDB = remember { mutableStateOf(true) }
    val feedbackMessage = remember { mutableStateOf("") }
    val isError = remember { mutableStateOf(false) }

    // Used to simulate checking the database and handling the login logic
    LaunchedEffect(username, password) {
        // Simulate DB check delay for user experience
        kotlinx.coroutines.delay(2000) //kept this for nice user feedback + it looks nice

        // Check credentials with ViewModel
        val validUser = userViewModel.checkLoginCredentials(username, password)

        loadingDB.value = false
        if (validUser) {
            feedbackMessage.value = "Login Successful"
            isError.value = false
            // Let the user read success message before navigation
            kotlinx.coroutines.delay(1000)
            navController.navigate(Screen.SendPINandLockStatusScreen.route)
        } else {
            feedbackMessage.value = "Login Failed"
            isError.value = true
            // Let the user read failure message before navigating back to login screen
            kotlinx.coroutines.delay(1000)
            navController.navigate(Screen.LoginScreen.route) {
                popUpTo(Screen.LoginScreen.route) {
                    inclusive = true // Remove LoginScreen from the stack
                }
            }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        // Indicating database check
        Text(
            text = "Checking Database...",
            modifier = Modifier
                .statusBarsPadding()
                .padding(16.dp),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
        )

        // Circular Progress Indicator for loading state
        if (loadingDB.value) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        // Display Feedback after checking the DB
        if (!loadingDB.value) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = feedbackMessage.value,
                    color = if (isError.value) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}


/*
*************************
*****    PREVIEW    *****
*************************

Preview Commented Out to Save Memory

//Login Check DB Splash Screen Preview
@Preview(showBackground = true)
@Composable
fun LoginCheckDBSplashScreenPreview() {
    ECE_544x558_Final_Project_AppTheme {
        LoginCheckDBSplashScreen()
    }
}

*/
