//Copyright 1986-2022 Xilinx, Inc. All Rights Reserved.
//--------------------------------------------------------------------------------
//Tool Version: Vivado v.2022.2 (win64) Build 3671981 Fri Oct 14 05:00:03 MDT 2022
//Date        : Tue Mar 18 16:31:22 2025
//Host        : Dawgburts-Mothership running 64-bit major release  (build 9200)
//Command     : generate_target embsys9_wrapper.bd
//Design      : embsys9_wrapper
//Purpose     : IP block netlist
//--------------------------------------------------------------------------------
`timescale 1 ps / 1 ps

module embsys9_wrapper
   (fan_out_tri_o,
    led_out_tri_o,
    reset,
    reset_0,
    sys_clock,
    usb_uart_rxd,
    usb_uart_txd);
  output [0:0]fan_out_tri_o;
  output [0:0]led_out_tri_o;
  input reset;
  input reset_0;
  input sys_clock;
  input usb_uart_rxd;
  output usb_uart_txd;

  wire [0:0]fan_out_tri_o;
  wire [0:0]led_out_tri_o;
  wire reset;
  wire reset_0;
  wire sys_clock;
  wire usb_uart_rxd;
  wire usb_uart_txd;

  embsys9 embsys9_i
       (.fan_out_tri_o(fan_out_tri_o),
        .led_out_tri_o(led_out_tri_o),
        .reset(reset),
        .reset_0(reset_0),
        .sys_clock(sys_clock),
        .usb_uart_rxd(usb_uart_rxd),
        .usb_uart_txd(usb_uart_txd));
endmodule
