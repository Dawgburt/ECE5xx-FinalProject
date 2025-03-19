package ece5xx.joint.project.app_Nick_A_Phil_N

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.navigation.NavController

//Add User for the App
//User Enters and Verifies Username, Password, and PIN. Adds to database with proper checking
@Composable
fun AddUserScreen(navController: NavController)
{
    //Variable to store the Username, Passowrd, PIN and associated Verifications
    //rememberSaveable persists across config changes and pausing the app
    val username = rememberSaveable { mutableStateOf("")} //empty string
    val usernameVerify = rememberSaveable { mutableStateOf("")} //empty string
    val password = rememberSaveable { mutableStateOf("")} //empty string
    val passwordVerify = rememberSaveable { mutableStateOf("")} //empty string
    val passwordVisible = remember { mutableStateOf(false) } //password is not visible by default
    val passwordVerifyVisible = remember { mutableStateOf(false) } //password is not visible by default
    val PIN = rememberSaveable { mutableStateOf("")} //empty string
    val PINVerify = rememberSaveable { mutableStateOf("")} //empty string
    val PINVisible = remember { mutableStateOf(false) } //PIN is not visible by default
    val PINVerifyVisible = remember { mutableStateOf(false) } //PIN is not visible by default

    //States to hold Username/Password Error messages
    val usernameError = remember { mutableStateOf("") } //no error message
    val usernameVerifyError = remember { mutableStateOf("") } //no error message
    val passwordError = remember { mutableStateOf("") } //no error message
    val passwordVerifyError = remember { mutableStateOf("") } //no error message
    val PINError = remember { mutableStateOf("") } //no error message
    val PINVerifyError = remember { mutableStateOf("") } //no error message

    Column(modifier = Modifier.verticalScroll(rememberScrollState())){ //screen is too big for my galaxy s25 so this will allow me to scroll
        //Arrow Back button
        Box(
            modifier = Modifier.fillMaxWidth() .statusBarsPadding(),
            contentAlignment = Alignment.TopStart
        ) {
            IconButton(onClick = {
                //Navigation to Login Screen
                navController.navigate(Screen.LoginScreen.route){
                    popUpTo(Screen.LoginScreen.route){
                        inclusive = true //Pop the Login Screen. Otherwise it accumulates on the stack during round trips
                    }
                }
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
        }

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
        if (usernameVerifyError.value.isNotEmpty()){
            Text(
                text = usernameVerifyError.value,
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

        //Verify Password Text Field
        //Makes text obscured by default. Can be toggled to see text
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
        //Makes text obscured by default. Can be toggled to see text
        OutlinedTextField(value = PIN.value, onValueChange = { newPIN ->
            PIN.value = newPIN
            PINError.value = "" //Clear error when user types
        },
            label = { Text("PIN") },
            visualTransformation = if (PINVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            isError = PINError.value.isNotEmpty(), //Show error if there is one
            trailingIcon = {
                IconButton(onClick = { PINVisible.value = !PINVisible.value }){
                    val icon = if (PINVisible.value) {
                        Icons.Default.VisibilityOff
                    }
                    else{
                        Icons.Default.Visibility
                    }
                    Icon(imageVector = icon, contentDescription = "Toggle PIN Visibility")
                }
            },
            modifier = Modifier.padding(16.dp)
        )
        if (PINError.value.isNotEmpty()){
            Text(
                text = PINError.value,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        //Verify PIN Text Field
        //Makes text obscured by default. Can be toggled to see text
        OutlinedTextField(value = PINVerify.value, onValueChange = { newPINVerify ->
            PINVerify.value = newPINVerify
            PINVerifyError.value = "" //Clear error when user types
        },
            label = { Text("Verify PIN") },
            visualTransformation = if (PINVerifyVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            isError = PINVerifyError.value.isNotEmpty(), //Show error if there is one
            trailingIcon = {
                IconButton(onClick = { PINVerifyVisible.value = !PINVerifyVisible.value }){
                    val icon = if (PINVerifyVisible.value) {
                        Icons.Default.VisibilityOff
                    }
                    else{
                        Icons.Default.Visibility
                    }
                    Icon(imageVector = icon, contentDescription = "Toggle Verify PIN Visibility")
                }
            },
            modifier = Modifier.padding(16.dp)
        )
        if (PINVerifyError.value.isNotEmpty()){
            Text(
                text = PINVerifyError.value,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        //Button to ADD User to DB
        //Adds User to DB if that user does not already exist
        //Will not proceed until all fields are filled out and
        //the username/Password/PINs are verified
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
                        username.value.lowercase() == "null" -> {
                            usernameError.value = "Username cannot be null"
                        }
                        usernameVerify.value.isEmpty() -> {
                            usernameVerifyError.value = "Verify Username cannot be empty"
                        }
                        username.value != usernameVerify.value -> {  // Check if username and Verify Username match
                            usernameVerifyError.value = "Usernames must match"
                        }
                        password.value.isEmpty() -> {
                            passwordError.value = "Password cannot be empty"
                        }
                        password.value.lowercase() == "null" -> {
                            passwordError.value = "Password cannot be null"
                        }
                        passwordVerify.value.isEmpty() -> {
                            passwordVerifyError.value = "Verify Password cannot be empty"
                        }
                        password.value != passwordVerify.value -> {  // Check if password and Verify Password match
                            passwordVerifyError.value = "Passwords must match"
                        }
                        PIN.value.isEmpty() -> {
                            PINError.value = "PIN cannot be empty"
                        }
                        !PIN.value.matches(Regex("^[0-9]{4}$")) -> {  // Check if PIN contains exactly 4 digits
                            PINError.value = "PIN must be 4 digits and numeric"
                        }
                        PINVerify.value.isEmpty() -> {
                            PINVerifyError.value = "Verify PIN cannot be empty"
                        }
                        !PINVerify.value.matches(Regex("^[0-9]{4}$")) -> {  // Check if PIN contains exactly 4 digits
                            PINVerifyError.value = "PIN must be 4 digits and numeric"
                        }
                        PIN.value != PINVerify.value -> {  // Check if PIN and Verify PIN match
                            PINVerifyError.value = "PINs must match"
                        }
                        else -> {
                            //Launch To Add User Check DB Splash Screen, SEND USERNAME, PASSWORD, and PIN
                            navController.navigate("add_user_check_db_splash_screen/${username.value}/${password.value}/${PIN.value}")
                        }
                    }
                }
            ){
                Text(
                    text = "ADD USER"
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

//Add User Screen Preview
@Preview(showBackground = true)
@Composable
fun AddUserScreenPreview() {
    ECE_544x558_Final_Project_AppTheme {
        AddUserScreen()
    }
}

*/