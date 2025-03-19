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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.navigation.NavController


//Login Screen for the App
//This is the home screen
@Composable
fun LoginScreen(navController: NavController)
{
    //Variable to store the username and Password
    //rememberSaveable persists across config changes and pausing the app
    val username = rememberSaveable { mutableStateOf("")} //empty string
    val password = rememberSaveable { mutableStateOf("")} //empty string
    val passwordVisible = remember { mutableStateOf(false) } //password is not visible by default

    //States to hold Username/Password Error messages
    val usernameError = remember { mutableStateOf("") } //no error message
    val passwordError = remember { mutableStateOf("") } //no error message

    Column()
    {
        //Text for the name of the app
        Text(
            text = "RemoteKey Admin Test Portal",
            modifier = Modifier
                .statusBarsPadding()
                .padding(16.dp),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
        )
        //Text to display "Login"
        Text(
            text = "Login:",
            modifier = Modifier
                .padding(16.dp),
            style = MaterialTheme.typography.headlineMedium
        )

        //TextFields for Username and Password
        //Username Text Field
        OutlinedTextField(value = username.value, onValueChange = { newUsername ->
            username.value = newUsername
            usernameError.value = "" //Clear error when user types
        },
            label = { Text("Username") },
            isError = usernameError.value.isNotEmpty(), //Show error if there is one
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

        //Password Text Field
        //Makes text obscured by default. Can be toggled to see text
        OutlinedTextField(value = password.value, onValueChange = { newPassword ->
            password.value = newPassword
            passwordError.value = "" //Clear error when user types
        },
            label = { Text("Password") },
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            isError = passwordError.value.isNotEmpty(), //Show error if there is one
            trailingIcon = {
                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }){
                    val icon = if (passwordVisible.value) {
                        Icons.Default.VisibilityOff
                    }
                    else{
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

        //Text to display "Add New User"
        Text(
            text = "Add New User:",
            modifier = Modifier
                .padding(start = 16.dp, top = 40.dp, bottom = 16.dp, end = 16.dp),
            style = MaterialTheme.typography.headlineMedium
        )

        //Button to go to Add User Screen
        Box(
            modifier = Modifier.fillMaxWidth()
        ){
            Button(
                modifier = Modifier.height(80.dp) .width(150.dp) .padding(16.dp),
                shape = MaterialTheme.shapes.medium,
                onClick = {
                    //Navigate to the Add user Screen
                    navController.navigate(Screen.AddUserScreen.route)
                }
            ){
                Text(
                    text = "Add User"
                )
            }
        }

        //Login Button
        //Goes to Check DB Splash Screen
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ){
            Button(
                modifier = Modifier.height(100.dp) .fillMaxWidth() .padding(start = 16.dp, end = 16.dp) .navigationBarsPadding(), //avoid navigation bar for buttons located on the bottom
                shape = MaterialTheme.shapes.medium,
                onClick = {
                    //Validate username and password before shifting screens
                    when{
                        username.value.isEmpty() -> {
                            usernameError.value = "Username cannot be empty"
                        }
                        password.value.isEmpty() -> {
                            passwordError.value = "Password cannot be empty"
                        }
                        else -> {
                            //Send Username and Password to the Login Check DB Splash Screen for DB Checking
                            navController.navigate("login_check_db_splash_screen/${username.value}/${password.value}")
                        }
                    }
                }
            ){
                Text(
                    text = "LOGIN"
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

//Login Screen Preview
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ECE_544x558_Final_Project_AppTheme {
        LoginScreen()
    }
}

*/