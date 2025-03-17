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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ece5xx.joint.project.app_Nick_A_Phil_N.ui.theme.ECE_544x558_Final_Project_AppTheme
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.foundation.layout.Arrangement


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ECE_544x558_Final_Project_AppTheme {
                //LoginScreen() //Home Screen

                //Only here for preview purposes
                //AddUserScreen()
                //AddUserCheckDBSplashScreen()
                LoginCheckDBSplashScreen()
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

    Column(){
        //Arrow Back button
        Box(
            modifier = Modifier.fillMaxWidth().padding(4.dp),
            contentAlignment = Alignment.TopStart
        ) {
            IconButton(onClick = {
                // TODO add navigation to Login Screen
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

        //Verify PIN Text Field //todo here
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
                modifier = Modifier.height(80.dp) .fillMaxWidth() .padding(16.dp),
                shape = MaterialTheme.shapes.medium,
                onClick = {
                    //Validate username and password before shifting screens
                    when{
                        username.value.isEmpty() -> {
                            usernameError.value = "Username cannot be empty"
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
                            //TODO Launch To Add User Check DB Splash Screen
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


//Login Check DataBase (DB) Splash Screen
//Indicates to User that the DataBase is being checked after Login attempt and
//if the username and password match goes to the Lock Status Screen
//else if the username and password don't match, goes back to the Login Screen
@Composable
fun LoginCheckDBSplashScreen() {
    val loadingDB = remember { mutableStateOf(true) }
    val feedbackMessage = remember { mutableStateOf("") }
    val isError = remember { mutableStateOf(false) }

    var isUserNameValid = remember { mutableStateOf(false) }
    var isPasswordValid = remember { mutableStateOf(false) }
    var mismatchCount = rememberSaveable { mutableStateOf(0) }

    // Countdown timer state
    val countdownTime = remember { mutableStateOf(30) }
    val countdownText = remember { mutableStateOf("30s") }

    // Start countdown when mismatch count is >= 1
    LaunchedEffect(mismatchCount.value) {
        if (mismatchCount.value >= 1) {
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

            // Update State Based on the Result
            loadingDB.value = false
            if ((!isUserNameValid.value || !isPasswordValid.value) && mismatchCount.value < 1) {
                // 1 for test purposes, TODO change to 3 after testing
                feedbackMessage.value = "Login Failed"
                mismatchCount.value++
                isError.value = true
            } else if ((!isUserNameValid.value || !isPasswordValid.value) && mismatchCount.value >= 1) {
                // 1 for test purposes, TODO change to 3 after testing
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
                    // TODO: navigate to Send PIN and Lock Status Screen
                }
                // Username or Password Wrong, but not too many attempts
                else if ((!isUserNameValid.value || !isPasswordValid.value) && mismatchCount.value < 1) {
                    // TODO: navigate to Login Screen
                }
                // Username or Password Wrong and there were too many attempts
                else if ((!isUserNameValid.value || !isPasswordValid.value) && mismatchCount.value >= 1) {
                    // The countdown is happening here
                    feedbackMessage.value = "Security Lockout: ${countdownText.value}" // Accessing value here
                    // TODO: Implement navigation to Login Screen once countdown finishes
                }
            }
        }

        // Display the countdown timer if the mismatch count is >= 1 (lockout)
        if (mismatchCount.value >= 1 && countdownTime.value > 0) {
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






//New User Check DataBase (DB) Splash Screen
//Indicates to User that the DataBase is being checked after Add User to DB attempt and
//if the username is not taken already notifies user of Add success and goes to the Login Screen
//else if the username is taken, notifies user of Add failure and goes back to the Add User Screen
@Composable
fun AddUserCheckDBSplashScreen()
{
    val loadingDB = remember { mutableStateOf(true) }
    val feedbackMessage = remember { mutableStateOf("") }
    val isError = remember { mutableStateOf(false) }
    var isUserNameTaken = true //Var to be updated based on DB check

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
        ){
        //Text to Indicate Database is being checked
        Text(
            text = "Checking Database...",
            modifier = Modifier
                .statusBarsPadding()
                .padding(16.dp),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
        )

        //Circular Progress for Visual Flair
        if (loadingDB.value){
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }
        }
        LaunchedEffect(Unit){
            //Simulating 2s delay to simulate DB check
            kotlinx.coroutines.delay(4000)

            //Simulate result.
            isUserNameTaken = true //Var to be updated based on DB check

            //Update State Based on the Result
            loadingDB.value = false
            if (isUserNameTaken){
                feedbackMessage.value = "Username is taken"
                isError.value = true
            }
            else{
                feedbackMessage.value = "User added successfully"
            }
        }

        //Display Feedback after Checking DB
        if (!loadingDB.value){
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = feedbackMessage.value,
                    color = if (isError.value) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp)
                )
            }
            LaunchedEffect(isUserNameTaken) {
                if (isUserNameTaken)
                {
                    //TODO navigate to Add User Screen
                }
                else //Username is not taken
                {
                    //TODO navigate to Login Screen
                }
            }
        }
    }
}



/*
**************************
*****    PREVIEWS    *****
**************************
*/

//Place Active Preview Here (Done to save space
//Login Check DB Splash Screen Preview
@Preview(showBackground = true)
@Composable
fun LoginCheckDBSplashScreenPreview() {
    ECE_544x558_Final_Project_AppTheme {
        LoginCheckDBSplashScreen()
    }
}


/* Previews Placed Here to Save Memory

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

//Login Check DB Splash Screen Preview
@Preview(showBackground = true)
@Composable
fun LoginCheckDBSplashScreenPreview() {
    ECE_544x558_Final_Project_AppTheme {
        LoginCheckDBSplashScreen()
    }
}

//Add User Check DB Splash Screen Preview
@Preview(showBackground = true)
@Composable
fun AddUserCheckDBSplashScreenPreview() {
    ECE_544x558_Final_Project_AppTheme {
        AddUserCheckDBSplashScreen()
    }
}
*
* */

