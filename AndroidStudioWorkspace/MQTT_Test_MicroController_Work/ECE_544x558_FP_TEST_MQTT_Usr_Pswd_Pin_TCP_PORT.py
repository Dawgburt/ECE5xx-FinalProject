"""
Nick Allmeyer
ECE 554 x 558 Final Project

Description:
This MicroPython Code runs on a Huzzah32 board from adafruit.
It has an ESP32 chip which includes I2C connectivity as well
as WiFi capabilities.

This code is a heavily modified version of my weather station. It will first be tested over
the regular TCP Port and once that works, that code will be included in a comment and I will switch over to a
TLS TCP Port for testing the final application.

The board uses WiFi to connect to a public MQTT broker and sends the weather data to an android
app for display. The andoriod app can also remotely toggle the red led. 

Credits and Thanks:
Electronic Clinic's youtube video "MicroPython on ESP32 Getting Started Tutorial"
(invaluable for getting thonny and the huzzah 32 up and running)

ChatGPT: Debugging adn Code Generation

HiveMQ for having a nice, free, public MQTT broker.
"""

import time
from umqtt.simple import MQTTClient
import network

# Wi-Fi List
wifi_ssid = "AllMeyer"
wifi_password = "Blackwind1994"

wifi = network.WLAN(network.STA_IF)
wifi.active(True)
time.sleep(5)
wifi.connect(wifi_ssid, wifi_password)

# Wait for Connection
wifi_timeout = 0
while not wifi.isconnected():
    print('Connecting to WiFi...')
    wifi_timeout = wifi_timeout + 1
    time.sleep(1)
    if wifi_timeout >= 180:
        raise Exception("WiFi Connection Timed Out")
    
print('Connected to WiFi')
print('IP Address:', wifi.ifconfig()[0])

# MQTT Setup
mqtt_server = 'broker.hivemq.com'
mqtt_port = 1883
mqtt_client_id = 'ECE_554x558_FP_App_Test_MQTT'

# MQTT Client Instance
mqtt_client = MQTTClient(mqtt_client_id, mqtt_server, mqtt_port)

# MQTT Timeout Variables
mqtt_timeout_limit = 5
mqtt_timeout_counter = 0

# Notify user of attempted MQTT Broker Connection
print('Attempting to connect to MQTT Broker. This may take a moment.')

# Connect to the broker
while mqtt_timeout_counter < mqtt_timeout_limit:
    try:
        mqtt_client.connect()
        print('Connected to MQTT Broker\n')
        break  # Exit the loop if connection is successful
    except Exception as e:
        print(f"Connection attempt failed: {e}")
        mqtt_timeout_counter += 1
        print(f"Retrying... ({mqtt_timeout_counter}/{mqtt_timeout_limit})")
        time.sleep(1)  # Wait before retrying

# If connection wasn't successful after timeout_limit attempts, raise an error
if mqtt_timeout_counter >= mqtt_timeout_limit:
    print("Failed to connect to the MQTT broker within the timeout limit.")
    raise Exception("MQTT connection timeout reached!")

# Simulated database of users
user_database = {
    "test1": {"password": "a", "pin": "1234"},
    "nick": {"password": "adminpass", "pin": "5678"}
}

# Separate variables for username, password, and pin for comparison
username_received = None
password_received = None
pin_received = None
expected_username = None
expected_password = None
expected_pin = None

def handle_username(topic, msg):
    """Handles username authentication."""
    global username_received, expected_username
    try:
        username_received = str(msg, 'utf-8')
        if username_received in user_database:
            expected_username = username_received
            print(f"Username Accepted: {username_received}")
        else:
            print(f"Invalid Username: {username_received}")
    except Exception as e:
        print(f"Error in username handling: {str(e)}")

def handle_password(topic, msg):
    """Handles password authentication."""
    global password_received, expected_password, expected_pin, expected_username
    try:
        password_received = str(msg, 'utf-8')
        if expected_username and expected_username in user_database:
            if user_database[expected_username]["password"] == password_received:
                expected_password = password_received
                expected_pin = user_database[expected_username]["pin"]
                print(f"Password Accepted for {expected_username}")
            else:
                print(f"Invalid Password for {expected_username}")
        else:
            print("Username Not Provided")
    except Exception as e:
        print(f"Error in password handling: {str(e)}")

def handle_pin(topic, msg):
    """Handles PIN verification."""
    global pin_received, expected_pin
    pin_received = str(msg, 'utf-8')

    if pin_received == expected_pin:
        lock_status = "Match Found - Unlocking"
        time.sleep(10)  # Simulate unlocking
        lock_status = "Lock Closed"
    else:
        lock_status = "No Match Found"

    # Print the lock status
    print(f"Lock Status: {lock_status}")
    # Publish lock status to MQTT
    mqtt_client.publish("ECE544x558/FP/App/RemoteKey/LockStatus", lock_status)

# Subscribe to topics
mqtt_client.set_callback(handle_username)
mqtt_client.subscribe("ECE544x558/FP/App/RemoteKey/Username")

mqtt_client.set_callback(handle_password)
mqtt_client.subscribe("ECE544x558/FP/App/RemoteKey/Password")

mqtt_client.set_callback(handle_pin)
mqtt_client.subscribe("ECE544x558/FP/App/RemoteKey/PIN")

# Loop to process MQTT messages
while True:
    mqtt_client.check_msg()
    time.sleep(1)  # Avoid high CPU usage
