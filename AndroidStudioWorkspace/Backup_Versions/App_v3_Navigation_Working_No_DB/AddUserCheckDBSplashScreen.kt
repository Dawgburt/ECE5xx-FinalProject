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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.foundation.layout.Arrangement
import androidx.navigation.NavController


//New User Check DataBase (DB) Splash Screen
//Indicates to User that the DataBase is being checked after Add User to DB attempt and
//if the username is not taken already notifies user of Add success and goes to the Login Screen
//else if the username is taken, notifies user of Add failure and goes back to the Add User Screen
@Composable
fun AddUserCheckDBSplashScreen(navController: NavController, username: String, password: String, PIN: String)
{
    val loadingDB = remember { mutableStateOf(true) }
    val feedbackMessage = remember { mutableStateOf("") }
    val isError = remember { mutableStateOf(false) }
    var isUserNameTaken = false //Var to be updated based on DB check

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
            if (username == "test1"){
                isUserNameTaken = true //Var to be updated based on DB check
            }

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
                //1 second delay to let user read feedback
                kotlinx.coroutines.delay(1000)
                
                if (isUserNameTaken)
                {
                    //Username is taken so Adding User FAILS. Return to Add User Screen to try again
                    navController.navigate(Screen.AddUserScreen.route){
                        popUpTo(Screen.AddUserCheckDBSplashScreen.route){
                            inclusive = true //Remove Add User Check DB Splash Screen from back stack
                        }
                    }
                }
                else //Username is not taken
                {
                    //User is successful in updating the DB so they get sent back to the login screen to login
                    navController.navigate(Screen.LoginScreen.route){
                        popUpTo(Screen.AddUserCheckDBSplashScreen.route){
                            inclusive = true //Remove Add User Check DB Splash Screen from back stack
                        }
                    }
                }
            }
        }
    }
}

/*
*************************
*****    PREVIEW    *****
*************************

Preview Commented Out to Save Memory

//Add User Check DB Splash Screen Preview
@Preview(showBackground = true)
@Composable
fun AddUserCheckDBSplashScreenPreview() {
    ECE_544x558_Final_Project_AppTheme {
        AddUserCheckDBSplashScreen()
    }
}

*/