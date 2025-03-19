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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import android.util.Log
import org.eclipse.paho.client.mqttv3.*


@Composable
fun SendPINandLockStatusScreen(navController: NavController, username: String, password: String){
    //Variables here
    val PIN = rememberSaveable { mutableStateOf("")} //empty string
    val PINVisible = remember { mutableStateOf(false) } //PIN is not visible by default
    val PINError = remember { mutableStateOf("") } //no error message

    // Variable to display lock status from the microcontroller
    val lockStatus = remember { mutableStateOf("Waiting for status...") }

    // MQTT Helper to interact with the MQTT Broker
    val mqttHelper = remember { MqttHelper() }

    // Subscribe to the lock status topic when the screen is created
    LaunchedEffect(true) {
        mqttHelper.connect()
        mqttHelper.subscribeToLockStatus {
            // Update lock status when a message is received from the microcontroller
            lockStatus.value = it
        }
    }

    Column(){
        //Arrow Back button
        Box(
            modifier = Modifier.fillMaxWidth() .statusBarsPadding(),
            contentAlignment = Alignment.TopStart
        ) {
            IconButton(onClick = {
                //Navigate to the Login Screen
                //By popping the back stack (this way navigation to login won't appear on top
                //Handles popping from current screen (Send PIN and Lock Status Screen)
                //through Login Check DB Splash Screen thus returning to Login Screen
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

        // Display the lock status from the microcontroller
        Text(
            text = "Lock Status: ${lockStatus.value}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )

        //Button to Send Pin
        //Prevents Sending of a blank PIN
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ){
            Button(
                modifier = Modifier.height(100.dp) .fillMaxWidth() .padding(start = 16.dp, end = 16.dp) .navigationBarsPadding(), //avoid navigation bar for buttons located on the bottom
                shape = MaterialTheme.shapes.medium,
                onClick = {
                    //Makes Sure PIN is not blank. No other error checking for security
                    when{
                        PIN.value.isEmpty() -> {
                            PINError.value = "PIN cannot be empty"
                        }
                        else -> {
                            //SEND PIN VIA MQTT
                            mqttHelper.publishMessage("ECE544x558/FP/App/RemoteKey/Username", username)
                            mqttHelper.publishMessage("ECE544x558/FP/App/RemoteKey/Password", password)
                            mqttHelper.publishMessage("ECE544x558/FP/App/RemoteKey/PIN", PIN.value)
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

//MQTT Helper Class Placed Here for Ease of Use in Project
//Too much overhead at this stage if moved to a separate file
class MqttHelper {
    private val mqttClient: MqttClient
    private val mqttConnectOptions: MqttConnectOptions
    private val brokerUrl = "tcp://broker.hivemq.com:1883"

    init {
        mqttClient = MqttClient(brokerUrl, MqttClient.generateClientId(), null)
        mqttConnectOptions = MqttConnectOptions()
        mqttConnectOptions.isCleanSession = true
    }

    fun connect() {
        try {
            mqttClient.connect(mqttConnectOptions)
            Log.d("MQTT", "Connected to MQTT broker")
        } catch (e: MqttException) {
            Log.e("MQTT", "Failed to connect", e)
        }
    }

    fun subscribeToLockStatus(onMessageReceived: (String) -> Unit) {
        try {
            mqttClient.subscribe("ECE544x558/FP/App/RemoteKey/LockStatus")
            mqttClient.setCallback(object : MqttCallback {
                override fun messageArrived(topic: String, message: MqttMessage) {
                    // Update lock status with the message received from the microcontroller
                    onMessageReceived(message.toString())
                }

                override fun connectionLost(cause: Throwable?) {
                    Log.e("MQTT", "Connection lost", cause)
                }

                override fun deliveryComplete(token: IMqttDeliveryToken?) {}
            })
        } catch (e: MqttException) {
            Log.e("MQTT", "Failed to subscribe", e)
        }
    }

    fun publishMessage(topic: String, message: String) {
        try {
            val mqttMessage = MqttMessage(message.toByteArray())
            mqttClient.publish(topic, mqttMessage)
        } catch (e: MqttException) {
            Log.e("MQTT", "Failed to publish message", e)
        }
    }

    fun disconnect() {
        try {
            mqttClient.disconnect()
            Log.d("MQTT", "Disconnected from MQTT broker")
        } catch (e: MqttException) {
            Log.e("MQTT", "Failed to disconnect", e)
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