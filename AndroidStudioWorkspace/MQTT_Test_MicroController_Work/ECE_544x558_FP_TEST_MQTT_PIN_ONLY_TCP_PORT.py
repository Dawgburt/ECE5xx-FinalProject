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

import machine
from machine import Pin
import time
from umqtt.simple import MQTTClient
import network

#Initialize RED LED (GPIO 32, Pin no. 20)
led = machine.Pin(32, machine.Pin.OUT)
led.value(0)

#Wi Fi List
"""
Nick Allmeyer home Wifi:
SSID: AllMeyer
Password: Blackwind1994

WCC:
SSID: 'PCCGuest'
Password: ''
"""
#Connect to WiFi
wifi_ssid = "AllMeyer"
wifi_password = "Blackwind1994"

wifi = network.WLAN(network.STA_IF)
wifi.active(True)
time.sleep(5)
wifi.connect(wifi_ssid, wifi_password)

#Wait for Connection
#Implements timeout at 60 seconds
wifi_timeout = 0 #variable to timeout if wifi doesn't connect
while not wifi.isconnected():
    print('Connecting to WiFi...')
    wifi_timeout = wifi_timeout + 1
    time.sleep(1)
    if wifi_timeout >= 180: #60 seconds have passed
        raise Exception("WiFi Connection Timed Out")
    
print('Connected to WiFi')
print('IP Address:', wifi.ifconfig()[0]) #Print the IP Address

#MQTT Setup
#MQTT Broker Details

mqtt_server = 'broker.hivemq.com' #Alternates: broker.hivemq.com #test.mosquitto.org
mqtt_port = 1883 #TCP Port 1883, TLS TCP Port: 
mqtt_client_id = 'ECE_554x558_FP_App_Test_MQTT' #Unique ID for device to test if MQTT is working on the App

#MQTT Client Instance
mqtt_client = MQTTClient(mqtt_client_id, mqtt_server, mqtt_port)

#MQTT Timeout Variables
mqtt_timeout_limit = 5 #attempts
mqtt_timeout_counter = 0

#Notify user of attempted MQTT Broker Connection
print('Attempting to connect to MQTT Broker. This may take a moment.')

#Connect to the broker
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

#Expected Pin for validation
EXPECTED_PIN = "1234"
lock_status = "Lock Closed"

def pin_callback(topic, msg):
    global lock_status
    received_pin = msg.decode('utf-8') #Converts byte message to readable string
    print(f"Received PIN: {received_pin}")
    
    if received_pin == EXPECTED_PIN:
        lock_status = "Match Found, Opening Lock"
        led.value(1)
        mqtt_client.publish('ECE544x558/FP/App/RemoteKey/LockStatus', lock_status, qos=1, retain=False)  # Publish Match Found immediately
        time.sleep(10)  # Simulate unlocking
        lock_status = "Lock Closed"
        led.value(0)
    else:
        lock_status  = "No Match Found"
        mqtt_client.publish('ECE544x558/FP/App/RemoteKey/LockStatus', lock_status, qos=1, retain=False)  # Publish Match Found immediately

mqtt_client.set_callback(pin_callback)
mqtt_client.subscribe('ECE544x558/FP/App/RemoteKey/PIN')

#Infinite loop, getting new environmental readings
#every 5 seconds
while True:
    #Handle incoming message for Getting Pin
    mqtt_client.check_msg()
    print(f"Current Lock Status: {lock_status}")
    mqtt_client.publish('ECE544x558/FP/App/RemoteKey/LockStatus', lock_status, qos=1, retain=False) #Qos of 1 for gaurenteed delivery. It unlocks an important door after all

    #Publish new results 5 seconds later
    time.sleep(5)
    
    
"""
TCP Port (1883) Working Code:


"""






