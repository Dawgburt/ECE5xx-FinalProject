package ece5xx.joint.project.app_Nick_A_Phil_N

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

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

    // This LaunchedEffect will handle both mismatch counting and countdown
    LaunchedEffect(mismatchCount.value) {
        if (mismatchCount.value >= mismatchLimit) {
            feedbackMessage.value = "Too Many Failed Login Attempts\n30s Security Lockout Enabled"

            // Wait for a moment to let the user read the feedback message before starting the countdown
            delay(1000) // Delay 1 second for the user to read the message

            // Start countdown if not already at 0
            while (countdownTime.value > 0) {
                delay(1000) // Wait for 1 second
                countdownTime.value -= 1
                countdownText.value = "${countdownTime.value}s" // Update the countdown text
            }

            // After countdown, navigate to login screen
            navController.navigate(Screen.LoginScreen.route) {
                popUpTo(Screen.LoginScreen.route) {
                    inclusive = true // Pop the Login Screen, so it doesn't accumulate on the stack
                }
            }
        } else {
            // Simulate database check
            kotlinx.coroutines.delay(4000) // Simulate DB delay
            // Assuming this is where you're checking the credentials:
            if (username == "test1") {
                isUserNameValid.value = true
            }
            if (password == "a") {
                isPasswordValid.value = true
            }

            // Handle login success/failure
            loadingDB.value = false
            if (isUserNameValid.value && isPasswordValid.value) {
                feedbackMessage.value = "Login Successful"
                mismatchCount.value = 0
                isError.value = false
                // Navigate to next screen
                kotlinx.coroutines.delay(1000) // Let user read success message
                navController.navigate(Screen.SendPINandLockStatusScreen.route)
            } else {
                feedbackMessage.value = "Login Failed"
                mismatchCount.value++
                isError.value = true
            }
        }
    }

    // UI layout
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

        // Display feedback after checking DB
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

        // Display the countdown timer if the mismatch count is >= 3 (lockout)
        if (mismatchCount.value >= mismatchLimit && countdownTime.value > 0) {
            Text(
                text = "Lockout: ${countdownText.value}",
                modifier = Modifier
                    .padding(16.dp)
                    .padding(top = 40.dp),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
        }
    }
}