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

@Composable
fun SendPINandLockStatusScreen(){
    //Variables here
    val PIN = rememberSaveable { mutableStateOf("")} //empty string
    val PINVisible = remember { mutableStateOf(false) } //PIN is not visible by default
    val PINError = remember { mutableStateOf("") } //no error message

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

        //Button to Send Pin
        //Prevents Sending of a blank PIN
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ){
            Button(
                modifier = Modifier.height(80.dp) .fillMaxWidth() .padding(16.dp),
                shape = MaterialTheme.shapes.medium,
                onClick = {
                    //Makes Sure PIN is not blank. No other error checking for security
                    when{
                        PIN.value.isEmpty() -> {
                            PINError.value = "PIN cannot be empty"
                        }
                        else -> {
                            //TODO SEND PIN VIA BT
                            //TODO ADD LOGIC TO HANDLE MESSAGES SENT BACK
                        }
                    }
                }
            ){
                Text(
                    text = "SEND PIN"
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

//Send PIN and Update Lock Status
@Preview(showBackground = true)
@Composable
fun SendPINandLockStatusScreenPreview() {
    ECE_544x558_Final_Project_AppTheme {
        SendPINandLockStatusScreen()
    }
}

*/