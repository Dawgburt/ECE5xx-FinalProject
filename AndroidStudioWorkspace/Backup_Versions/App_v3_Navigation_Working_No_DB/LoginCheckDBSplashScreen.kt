package ece5xx.joint.project.app_Nick_A_Phil_N

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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.foundation.layout.Arrangement
import androidx.navigation.NavController

//Login Check DataBase (DB) Splash Screen
//Indicates to User that the DataBase is being checked after Login attempt and
//if the username and password match goes to the Lock Status Screen
//else if the username and password don't match, goes back to the Login Screen
@Composable
fun LoginCheckDBSplashScreen(navController: NavController, username: String, password: String) {
    val loadingDB = remember { mutableStateOf(true) }
    val feedbackMessage = remember { mutableStateOf("") }
    val isError = remember { mutableStateOf(false) }

    var isUserNameValid = remember { mutableStateOf(false) }
    var isPasswordValid = remember { mutableStateOf(false) }
    var mismatchCount = rememberSaveable { mutableStateOf(0) }

    // Countdown timer state
    val countdownTime = remember { mutableStateOf(30) }
    val countdownText = remember { mutableStateOf("30s") }
    val mismatchLimit = 3

    //Used to Countdown Security Lockout Time
    // Start countdown when mismatch count is >= misMatchLimit (set 3 for real, 1 for testing pre nav/db)
    LaunchedEffect(mismatchCount.value) {
        if (mismatchCount.value >= mismatchLimit) {
            // Start the countdown if there are mismatches
            while (countdownTime.value > 0) {
                kotlinx.coroutines.delay(1000) // Wait for 1 second
                countdownTime.value -= 1
                countdownText.value = "${countdownTime.value}s" // Update the countdown text
            }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        // Text to Indicate Database is being checked
        Text(
            text = "Checking Database...",
            modifier = Modifier
                .statusBarsPadding()
                .padding(16.dp),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
        )

        // Circular Progress for Visual Flair
        if (loadingDB.value) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        LaunchedEffect(Unit) {
            // Simulating 2s delay to simulate DB check
            kotlinx.coroutines.delay(4000)
            //Navigation test values before addition of DB
            if (username == "test1"){
                isUserNameValid.value = true
            }
            if (password == "a"){
                isPasswordValid.value = true
            }

            // Update State Based on the Result
            loadingDB.value = false
            if ((!isUserNameValid.value || !isPasswordValid.value) && mismatchCount.value < mismatchLimit) {
                feedbackMessage.value = "Login Failed"
                mismatchCount.value++
                isError.value = true
            } else if ((!isUserNameValid.value || !isPasswordValid.value) && mismatchCount.value >= mismatchLimit) {
                feedbackMessage.value =
                    "Too Many Failed Login Attempts\n30s Security Lockout Enabled"
                mismatchCount.value++
                isError.value = true
            } else if (isUserNameValid.value && isPasswordValid.value) {
                feedbackMessage.value = "Login Successful"
                mismatchCount.value = 0
                isError.value = false
            }
        }

        // Display Feedback after Checking DB
        if (!loadingDB.value) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = feedbackMessage.value,
                    color = if (isError.value) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp)
                )
            }

            LaunchedEffect(mismatchCount.value) {
                if (isUserNameValid.value && isPasswordValid.value) {
                    //1 second delay to let user read feedback
                    kotlinx.coroutines.delay(1000)
                    //Navigate to Send PIN and Lock Status Screen
                    navController.navigate(Screen.SendPINandLockStatusScreen.route)
                }
                // Username or Password Wrong, but not too many attempts
                else if ((!isUserNameValid.value || !isPasswordValid.value) && mismatchCount.value < mismatchLimit) {
                    //1 second delay to let user read feedback
                    kotlinx.coroutines.delay(1000)
                    //Navigate to Login Screen
                    navController.navigate(Screen.LoginScreen.route){
                        popUpTo(Screen.LoginScreen.route){
                            inclusive = true //Pop the Login Screen. Otherwise it accumulates on the stack during round trips
                        }
                    }
                }
                // Username or Password Wrong and there were too many attempts
                else if ((!isUserNameValid.value || !isPasswordValid.value) && mismatchCount.value >= mismatchLimit) {
                    // The countdown is happening here
                    feedbackMessage.value = "Security Lockout: ${countdownText.value}" // Accessing value here
                    //1 second delay to let user read feedback
                    kotlinx.coroutines.delay(1000)
                    //Navigation to Login Screen once countdown finishes
                    navController.navigate(Screen.LoginScreen.route){
                        popUpTo(Screen.LoginScreen.route){
                            inclusive = true //Pop the Login Screen. Otherwise it accumulates on the stack during round trips
                        }
                    }
                }
            }
        }

        // Display the countdown timer if the mismatch count is >= 1 (lockout)
        if (mismatchCount.value >= mismatchLimit && countdownTime.value > 0) {
            Text(
                text = "Lockout: ${countdownText.value}", // Accessing value here
                modifier = Modifier
                    .padding(16.dp)
                    .padding(top = 40.dp),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
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