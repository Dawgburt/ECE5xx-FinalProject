/*
 * Smart Lock Vitis Application
 *
 * Description:
 * This application interfaces with a Bluetooth module (HC-05) using UARTLite
 * to receive and process PIN-based authentication commands. It simulates a
 * smart lock system by processing received data, verifying PIN input, and
 * toggling GPIO outputs for a servo and LED.
 *
 * Features:
 * - Initializes UARTLite for Bluetooth communication.
 * - Receives PIN input over Bluetooth and validates it.
 * - Sends status messages back to the connected device.
 * - Simulates GPIO control for a servo motor and LED.
 *
 * Hardware Requirements:
 * - FPGA Board: Nexys A7 100T
 * - Bluetooth Module: HC-05
 * - Connected to PMOD JB Header (UART TX/RX)
 * - Optional Servo and LED on GPIO JB[3] and JB[4]
 * - RPI5 for debugging and testing
 *
 * Author: Phil Nevins & Nick A.
 * Created: 3/8/2025
 * Last Update: 3/17/2025
 *
 * Note:
 * 3/8	PN		Project created and basic functionality to receive BT message complete.
 * 3/16	PN		Added functionality to simulate proper functionality (Plan F).
 * 				Bluetooth connection to HC-05 from outside devices never achieved.
 *
 */

#include <stdio.h>
#include "xparameters.h"
#include "xil_cache.h"
#include "uartlite_header.h"
#include "xuartlite.h"

#define UART_DEVICE_ID XPAR_UARTLITE_0_DEVICE_ID
#define BUFFER_SIZE 100

//Dummy variables for demonstration purposes
#define PIN 1234
#define ON 1
#define OFF 0

XUartLite UartLite;
u8 RecvBuffer[BUFFER_SIZE];

int main ()
{
   Xil_ICacheEnable();
   Xil_DCacheEnable();
   print("---Starting Smart Lock---\n\r");
      int status;

      // Initialize the UART Lite module
      status = XUartLite_Initialize(&UartLite, UART_DEVICE_ID);
      if (status != XST_SUCCESS) {
          xil_printf("UART Initialization Failed!\n\r");
          return XST_FAILURE;
      }
      xil_printf("UART Intialized...\n\r");
      xil_printf("Bluetooth Module detected...\n\r");

      while (1) {
          int ReceivedBytes = XUartLite_Recv(&UartLite, RecvBuffer, BUFFER_SIZE - 1);

          //Debug Display
          if (ReceivedBytes > 0) {
              RecvBuffer[ReceivedBytes] = '\0';
              xil_printf("Received: %s\n\r", RecvBuffer);
          }


          //wait for PIN
          if (ReceivedBytes == PIN){
        	  xil_printf("Pin Match Found! Opening Lock...\n\r");
        	  // Send message over Bluetooth
        	  u8 SendBuffer[] = "Match Found!";  // Message to send
        	  XUartLite_Send(&UartLite, SendBuffer, BUFFER_SIZE - 1);
        	  xil_printf("Message Sent: %s\n\r", SendBuffer);
        	  //usleep(1000);

        	  //Turn on LED and Servo
        	  //Send PWM Control Signal to Servo JB[3]. Channel 1
        	  //XGpio_DiscreteWrite(&GpioPWM, 1, ON);
        	  //Send PWM Control Signal to LED JB[4]. Channel 2
        	  //XGpio_DiscreteWrite(&GpioPWM, 2, ON);

        	  //usleep(3000); //Wait 3 seconds

        	  //Turn off LED and Servo
        	  //Send PWM Control Signal to Servo JB[3]. Channel 1
        	  //XGpio_DiscreteWrite(&GpioPWM, 1, OFF);
        	  //Send PWM Control Signal to LED JB[4]. Channel 2
        	  //XGpio_DiscreteWrite(&GpioPWM, 2, OFF);

        	  // Send message over Bluetooth
        	  u8 SendBuffer2[] = "Lock Open!";  // Message to send
        	  XUartLite_Send(&UartLite, SendBuffer2, BUFFER_SIZE - 1);
        	  xil_printf("Message Sent: %s\n\r", SendBuffer2);

        	  //Print to xil_console
        	  xil_printf("Lock Open!\n\r");

          } else {
        	  //Print to xil_console
        	  xil_printf("Pin Mismatch! Try again..\n\r");

        	  // Send message over Bluetooth
        	  u8 SendBuffer3[] = "Pin Mismatch!";  // Message to send
        	  XUartLite_Send(&UartLite, SendBuffer3, BUFFER_SIZE - 1);
        	  xil_printf("Message Sent: %s\n\r", SendBuffer3);

        	  //Toggle LED 3 times for "error state"
        	  //Send PWM Control Signal to LED JB[4]. Channel 2
        	  //XGpio_DiscreteWrite(&GpioPWM, 2, ON);
        	  //usleep(1000);
        	  //XGpio_DiscreteWrite(&GpioPWM, 2, OFF);
        	  //usleep(1000);

        	  //XGpio_DiscreteWrite(&GpioPWM, 2, ON);
        	  //usleep(1000);
        	  //XGpio_DiscreteWrite(&GpioPWM, 2, OFF);
        	  //usleep(1000);

        	  //XGpio_DiscreteWrite(&GpioPWM, 2, ON);
        	  //usleep(1000);
        	  //XGpio_DiscreteWrite(&GpioPWM, 2, OFF);
        	  //usleep(1000);
          }
      }
   print("---Exiting main---\n\r");
   Xil_DCacheDisable();
   Xil_ICacheDisable();
   return 0;

}
