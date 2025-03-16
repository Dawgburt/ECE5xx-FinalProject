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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ece5xx.joint.project.app_Nick_A_Phil_N.ui.theme.ECE_544x558_Final_Project_AppTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Surface
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ECE_544x558_Final_Project_AppTheme {
                //LoginScreen() //Home Screen

                //Only here for preview purposes
                AddUserScreen()
                //CheckDBSplashScreen()
            }
        }
    }
}


/*
*************************
*****    SCREENS    *****
*************************
*/

//Login Screen for the App
//This is the home screen
@Composable
fun LoginScreen()
{
    //Variable to store the username and Password
    //rememberSaveable persists across config changes and pausing the app
    var username = rememberSaveable() { mutableStateOf("")} //empty string
    var password = rememberSaveable { mutableStateOf("")} //empty string
    var passwordVisible = remember { mutableStateOf(false) } //password is not visible by default

    //States to hold Username/Password Error messages
    var usernameError = remember { mutableStateOf("") } //no error message
    var passwordError = remember { mutableStateOf("") } //no error message

    Column()
    {
        //Text for the name of the app
        Text(
            text = "RemoteKey",
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
        //Makes text input by default. Can be toggled to see text
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
                    //TODO NAVIGATE TO USER SCREEN
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
                modifier = Modifier.height(80.dp) .fillMaxWidth() .padding(16.dp),
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
                            //TODO NAVIGATE TO CHECK DB SPLASH SCREEN
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


//Add User for the App
//User Enters and Verifies Username, Password, and PIN. Adds to database with proper checking
@Composable
fun AddUserScreen()
{
    //Variable to store the Username, Passowrd, PIN and associated Verifications
    //rememberSaveable persists across config changes and pausing the app
    var username = rememberSaveable() { mutableStateOf("")} //empty string
    var usernameVerify = rememberSaveable() { mutableStateOf("")} //empty string
    var password = rememberSaveable { mutableStateOf("")} //empty string
    var passwordVerify = rememberSaveable { mutableStateOf("")} //empty string
    var passwordVisible = remember { mutableStateOf(false) } //password is not visible by default
    var passwordVerifyVisible = remember { mutableStateOf(false) } //password is not visible by default
    var PIN = rememberSaveable() { mutableStateOf("")} //empty string
    var PINVerify = rememberSaveable() { mutableStateOf("")} //empty string

    //States to hold Username/Password Error messages
    var usernameError = remember { mutableStateOf("") } //no error message
    var usernameVerifyError = remember { mutableStateOf("") } //no error message
    var passwordError = remember { mutableStateOf("") } //no error message
    var passwordVerifyError = remember { mutableStateOf("") } //no error message
    var PINError = remember { mutableStateOf("") } //no error message
    var PINVerifyError = remember { mutableStateOf("") } //no error message

    var usernameMismatch = remember { mutableStateOf(false) } //no error message
    var passwordMismatch = remember { mutableStateOf(false) } //no error message
    var PINMismatch = remember { mutableStateOf(false) } //no error message

    Column(){
        //TODO Add Back Button in Upper Left Corner

        //Header for the Add User Screen
        Text(
            text = "Add New User to Database:",
            modifier = Modifier
                .statusBarsPadding()
                .padding(16.dp),
            style = MaterialTheme.typography.headlineMedium
        )

        //TextFields for Username, Password, PIN, and Verifications

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

        //Verify Username Text Field
        OutlinedTextField(value = usernameVerify.value, onValueChange = { newUsernameVerify ->
            usernameVerify.value = newUsernameVerify
            usernameVerifyError.value = "" //Clear error when user types
        },
            label = { Text("Verify Username") },
            isError = usernameVerifyError.value.isNotEmpty(), //Show error if there is one
            modifier = Modifier.padding(16.dp)
        )
        if (usernameError.value.isNotEmpty()){
            Text(
                text = usernameVerifyError.value,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        //Password Text Field
        //Makes text input by default. Can be toggled to see text
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

        //Verify Password Text Field
        //Makes text input by default. Can be toggled to see text
        OutlinedTextField(value = passwordVerify.value, onValueChange = { newPasswordVerify ->
            passwordVerify.value = newPasswordVerify
            passwordVerifyError.value = "" //Clear error when user types
        },
            label = { Text("Verify Password") },
            visualTransformation = if (passwordVerifyVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            isError = passwordVerifyError.value.isNotEmpty(), //Show error if there is one
            trailingIcon = {
                IconButton(onClick = { passwordVerifyVisible.value = !passwordVerifyVisible.value }){
                    val icon = if (passwordVerifyVisible.value) {
                        Icons.Default.VisibilityOff
                    }
                    else{
                        Icons.Default.Visibility
                    }
                    Icon(imageVector = icon, contentDescription = "Toggle Verify Password Visibility")
                }
            },
            modifier = Modifier.padding(16.dp)
        )
        if (passwordVerifyError.value.isNotEmpty()){
            Text(
                text = passwordVerifyError.value,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        //PIN Text Field

        //Verify PIN Text Field

    }
}


//Check DataBase (DB) Splash Screen
//Indicates to User that the DataBase is being checked and
//if the username and password match goes to the Lock Status Screen
//else if the username and password don't match, goes back to the Login Screen
@Composable
fun CheckDBSplashScreen()
{
//TODO Write Splash Screen
}



/*
**************************
*****    PREVIEWS    *****
**************************
*/

//Login Screen Preview
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ECE_544x558_Final_Project_AppTheme {
        LoginScreen()
    }
}

//Add User Screen Preview
@Preview(showBackground = true)
@Composable
fun AddUserScreenPreview() {
    ECE_544x558_Final_Project_AppTheme {
        AddUserScreen()
    }
}

//Check DB Splash Screen Preview
@Preview(showBackground = true)
@Composable
fun CheckDBSplashScreenPreview() {
    ECE_544x558_Final_Project_AppTheme {
        CheckDBSplashScreen()
    }
}