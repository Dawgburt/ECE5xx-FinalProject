//Copyright 1986-2022 Xilinx, Inc. All Rights Reserved.
//--------------------------------------------------------------------------------
//Tool Version: Vivado v.2022.2 (win64) Build 3671981 Fri Oct 14 05:00:03 MDT 2022
//Date        : Sun Mar 16 12:09:36 2025
//Host        : Dawgburts-Mothership running 64-bit major release  (build 9200)
//Command     : generate_target dlembsys_wrapper.bd
//Design      : dlembsys_wrapper
//Purpose     : IP block netlist
//--------------------------------------------------------------------------------
`timescale 1 ps / 1 ps

module dlembsys_wrapper
   (reset,
    reset_0,
    sys_clock,
    usb_uart_rxd,
    usb_uart_txd);
  input reset;
  input reset_0;
  input sys_clock;
  input usb_uart_rxd;
  output usb_uart_txd;

  wire reset;
  wire reset_0;
  wire sys_clock;
  wire usb_uart_rxd;
  wire usb_uart_txd;

  dlembsys dlembsys_i
       (.reset(reset),
        .reset_0(reset_0),
        .sys_clock(sys_clock),
        .usb_uart_rxd(usb_uart_rxd),
        .usb_uart_txd(usb_uart_txd));
endmodule
