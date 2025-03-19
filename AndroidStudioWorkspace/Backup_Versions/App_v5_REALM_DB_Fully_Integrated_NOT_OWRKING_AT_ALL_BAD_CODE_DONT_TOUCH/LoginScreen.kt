package ece5xx.joint.project.app_Nick_A_Phil_N

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController


//Login Screen for the App
//This is the home screen
@Composable
fun LoginScreen(navController: NavController, userViewModel: UserViewModel) {
    // Variable to store the username and password
    val username = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }

    // States to hold Username/Password Error messages
    val usernameError = remember { mutableStateOf("") }
    val passwordError = remember { mutableStateOf("") }

    // A state to track the loading state (whether Realm is ready)
    val loading = remember { mutableStateOf(true) }

    // Check if Realm is ready (simulate initialization check)
    LaunchedEffect(true) {
        // Simulate some delay for initializing the database
        kotlinx.coroutines.delay(1000)  // Optional: Remove if you want instant initialization

        loading.value = false  // Once initialized, we can proceed
    }

    Column() {
        Text(
            text = "RemoteKey Admin Test Portal",
            modifier = Modifier
                .statusBarsPadding()
                .padding(16.dp),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
        )

        Text(
            text = "Login:",
            modifier = Modifier
                .padding(16.dp),
            style = MaterialTheme.typography.headlineMedium
        )

        // Username Text Field
        OutlinedTextField(
            value = username.value,
            onValueChange = { newUsername ->
                username.value = newUsername
                usernameError.value = "" // Clear error when user types
            },
            label = { Text("Username") },
            isError = usernameError.value.isNotEmpty(),
            modifier = Modifier.padding(16.dp)
        )
        if (usernameError.value.isNotEmpty()){
            Text(
                text = usernameError.value,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        // Password Text Field
        OutlinedTextField(
            value = password.value,
            onValueChange = { newPassword ->
                password.value = newPassword
                passwordError.value = "" // Clear error when user types
            },
            label = { Text("Password") },
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            isError = passwordError.value.isNotEmpty(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    val icon = if (passwordVisible.value) {
                        Icons.Default.VisibilityOff
                    } else {
                        Icons.Default.Visibility
                    }
                    Icon(imageVector = icon, contentDescription = "Toggle Password Visibility")
                }
            },
            modifier = Modifier.padding(16.dp)
        )
        if (passwordError.value.isNotEmpty()){
            Text(
                text = passwordError.value,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        // "Add New User" Section
        Text(
            text = "Add New User:",
            modifier = Modifier
                .padding(start = 16.dp, top = 40.dp, bottom = 16.dp, end = 16.dp),
            style = MaterialTheme.typography.headlineMedium
        )

        // Button to go to Add User Screen
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                modifier = Modifier.height(80.dp).width(150.dp).padding(16.dp),
                shape = MaterialTheme.shapes.medium,
                onClick = {
                    navController.navigate(Screen.AddUserScreen.route)
                }
            ) {
                Text(text = "Add User")
            }
        }

        // Login Button (only enable once Realm is initialized)
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
                modifier = Modifier.height(100.dp).fillMaxWidth().padding(bottom = 50.dp, start = 16.dp, end = 16.dp),
                shape = MaterialTheme.shapes.medium,
                onClick = {
                    // Validate username and password before shifting screens
                    when {
                        username.value.isEmpty() -> {
                            usernameError.value = "Username cannot be empty"
                        }
                        password.value.isEmpty() -> {
                            passwordError.value = "Password cannot be empty"
                        }
                        loading.value -> {
                            usernameError.value = "Please wait, initializing database..."
                        }
                        else -> {
                            // Proceed to the login check screen
                            navController.navigate("login_check_db_splash_screen/${username.value}/${password.value}")
                        }
                    }
                }
            ) {
                Text(text = "LOGIN")
            }
        }
    }
}


/*
*************************
*****    PREVIEW    *****
*************************

Preview Commented Out to Save Memory

//Login Screen Preview
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ECE_544x558_Final_Project_AppTheme {
        LoginScreen()
    }
}

*/