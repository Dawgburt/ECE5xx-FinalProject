// Copyright 1986-2022 Xilinx, Inc. All Rights Reserved.
// --------------------------------------------------------------------------------
// Tool Version: Vivado v.2022.2 (win64) Build 3671981 Fri Oct 14 05:00:03 MDT 2022
// Date        : Sun Mar 16 11:42:58 2025
// Host        : Dawgburts-Mothership running 64-bit major release  (build 9200)
// Command     : write_verilog -force -mode funcsim
//               c:/SimpleLock/DigitalLockv2/DigitalLockv2.gen/sources_1/bd/dlembsys/ip/dlembsys_axi_bram_ctrl_0_bram_0/dlembsys_axi_bram_ctrl_0_bram_0_sim_netlist.v
// Design      : dlembsys_axi_bram_ctrl_0_bram_0
// Purpose     : This verilog netlist is a functional simulation representation of the design and should not be modified
//               or synthesized. This netlist cannot be used for SDF annotated simulation.
// Device      : xc7a100tcsg324-1
// --------------------------------------------------------------------------------
`timescale 1 ps / 1 ps

(* CHECK_LICENSE_TYPE = "dlembsys_axi_bram_ctrl_0_bram_0,blk_mem_gen_v8_4_5,{}" *) (* downgradeipidentifiedwarnings = "yes" *) (* x_core_info = "blk_mem_gen_v8_4_5,Vivado 2022.2" *) 
(* NotValidForBitStream *)
module dlembsys_axi_bram_ctrl_0_bram_0
   (clka,
    rsta,
    ena,
    wea,
    addra,
    dina,
    douta,
    clkb,
    rstb,
    enb,
    web,
    addrb,
    dinb,
    doutb,
    rsta_busy,
    rstb_busy);
  (* x_interface_info = "xilinx.com:interface:bram:1.0 BRAM_PORTA CLK" *) (* x_interface_parameter = "XIL_INTERFACENAME BRAM_PORTA, MEM_SIZE 8192, MEM_WIDTH 32, MEM_ECC NONE, MASTER_TYPE BRAM_CTRL, READ_WRITE_MODE READ_WRITE, READ_LATENCY 1" *) input clka;
  (* x_interface_info = "xilinx.com:interface:bram:1.0 BRAM_PORTA RST" *) input rsta;
  (* x_interface_info = "xilinx.com:interface:bram:1.0 BRAM_PORTA EN" *) input ena;
  (* x_interface_info = "xilinx.com:interface:bram:1.0 BRAM_PORTA WE" *) input [3:0]wea;
  (* x_interface_info = "xilinx.com:interface:bram:1.0 BRAM_PORTA ADDR" *) input [31:0]addra;
  (* x_interface_info = "xilinx.com:interface:bram:1.0 BRAM_PORTA DIN" *) input [31:0]dina;
  (* x_interface_info = "xilinx.com:interface:bram:1.0 BRAM_PORTA DOUT" *) output [31:0]douta;
  (* x_interface_info = "xilinx.com:interface:bram:1.0 BRAM_PORTB CLK" *) (* x_interface_parameter = "XIL_INTERFACENAME BRAM_PORTB, MEM_SIZE 8192, MEM_WIDTH 32, MEM_ECC NONE, MASTER_TYPE BRAM_CTRL, READ_WRITE_MODE READ_WRITE, READ_LATENCY 1" *) input clkb;
  (* x_interface_info = "xilinx.com:interface:bram:1.0 BRAM_PORTB RST" *) input rstb;
  (* x_interface_info = "xilinx.com:interface:bram:1.0 BRAM_PORTB EN" *) input enb;
  (* x_interface_info = "xilinx.com:interface:bram:1.0 BRAM_PORTB WE" *) input [3:0]web;
  (* x_interface_info = "xilinx.com:interface:bram:1.0 BRAM_PORTB ADDR" *) input [31:0]addrb;
  (* x_interface_info = "xilinx.com:interface:bram:1.0 BRAM_PORTB DIN" *) input [31:0]dinb;
  (* x_interface_info = "xilinx.com:interface:bram:1.0 BRAM_PORTB DOUT" *) output [31:0]doutb;
  output rsta_busy;
  output rstb_busy;

  wire [31:0]addra;
  wire [31:0]addrb;
  wire clka;
  wire clkb;
  wire [31:0]dina;
  wire [31:0]dinb;
  wire [31:0]douta;
  wire [31:0]doutb;
  wire ena;
  wire enb;
  wire rsta;
  wire rsta_busy;
  wire rstb;
  wire rstb_busy;
  wire [3:0]wea;
  wire [3:0]web;
  wire NLW_U0_dbiterr_UNCONNECTED;
  wire NLW_U0_s_axi_arready_UNCONNECTED;
  wire NLW_U0_s_axi_awready_UNCONNECTED;
  wire NLW_U0_s_axi_bvalid_UNCONNECTED;
  wire NLW_U0_s_axi_dbiterr_UNCONNECTED;
  wire NLW_U0_s_axi_rlast_UNCONNECTED;
  wire NLW_U0_s_axi_rvalid_UNCONNECTED;
  wire NLW_U0_s_axi_sbiterr_UNCONNECTED;
  wire NLW_U0_s_axi_wready_UNCONNECTED;
  wire NLW_U0_sbiterr_UNCONNECTED;
  wire [31:0]NLW_U0_rdaddrecc_UNCONNECTED;
  wire [3:0]NLW_U0_s_axi_bid_UNCONNECTED;
  wire [1:0]NLW_U0_s_axi_bresp_UNCONNECTED;
  wire [31:0]NLW_U0_s_axi_rdaddrecc_UNCONNECTED;
  wire [31:0]NLW_U0_s_axi_rdata_UNCONNECTED;
  wire [3:0]NLW_U0_s_axi_rid_UNCONNECTED;
  wire [1:0]NLW_U0_s_axi_rresp_UNCONNECTED;

  (* C_ADDRA_WIDTH = "32" *) 
  (* C_ADDRB_WIDTH = "32" *) 
  (* C_ALGORITHM = "1" *) 
  (* C_AXI_ID_WIDTH = "4" *) 
  (* C_AXI_SLAVE_TYPE = "0" *) 
  (* C_AXI_TYPE = "1" *) 
  (* C_BYTE_SIZE = "8" *) 
  (* C_COMMON_CLK = "0" *) 
  (* C_COUNT_18K_BRAM = "0" *) 
  (* C_COUNT_36K_BRAM = "2" *) 
  (* C_CTRL_ECC_ALGO = "NONE" *) 
  (* C_DEFAULT_DATA = "0" *) 
  (* C_DISABLE_WARN_BHV_COLL = "0" *) 
  (* C_DISABLE_WARN_BHV_RANGE = "0" *) 
  (* C_ELABORATION_DIR = "./" *) 
  (* C_ENABLE_32BIT_ADDRESS = "1" *) 
  (* C_EN_DEEPSLEEP_PIN = "0" *) 
  (* C_EN_ECC_PIPE = "0" *) 
  (* C_EN_RDADDRA_CHG = "0" *) 
  (* C_EN_RDADDRB_CHG = "0" *) 
  (* C_EN_SAFETY_CKT = "1" *) 
  (* C_EN_SHUTDOWN_PIN = "0" *) 
  (* C_EN_SLEEP_PIN = "0" *) 
  (* C_EST_POWER_SUMMARY = "Estimated Power for IP     :     10.7492 mW" *) 
  (* C_FAMILY = "artix7" *) 
  (* C_HAS_AXI_ID = "0" *) 
  (* C_HAS_ENA = "1" *) 
  (* C_HAS_ENB = "1" *) 
  (* C_HAS_INJECTERR = "0" *) 
  (* C_HAS_MEM_OUTPUT_REGS_A = "0" *) 
  (* C_HAS_MEM_OUTPUT_REGS_B = "0" *) 
  (* C_HAS_MUX_OUTPUT_REGS_A = "0" *) 
  (* C_HAS_MUX_OUTPUT_REGS_B = "0" *) 
  (* C_HAS_REGCEA = "0" *) 
  (* C_HAS_REGCEB = "0" *) 
  (* C_HAS_RSTA = "1" *) 
  (* C_HAS_RSTB = "1" *) 
  (* C_HAS_SOFTECC_INPUT_REGS_A = "0" *) 
  (* C_HAS_SOFTECC_OUTPUT_REGS_B = "0" *) 
  (* C_INITA_VAL = "0" *) 
  (* C_INITB_VAL = "0" *) 
  (* C_INIT_FILE = "dlembsys_axi_bram_ctrl_0_bram_0.mem" *) 
  (* C_INIT_FILE_NAME = "no_coe_file_loaded" *) 
  (* C_INTERFACE_TYPE = "0" *) 
  (* C_LOAD_INIT_FILE = "0" *) 
  (* C_MEM_TYPE = "2" *) 
  (* C_MUX_PIPELINE_STAGES = "0" *) 
  (* C_PRIM_TYPE = "1" *) 
  (* C_READ_DEPTH_A = "2048" *) 
  (* C_READ_DEPTH_B = "2048" *) 
  (* C_READ_LATENCY_A = "1" *) 
  (* C_READ_LATENCY_B = "1" *) 
  (* C_READ_WIDTH_A = "32" *) 
  (* C_READ_WIDTH_B = "32" *) 
  (* C_RSTRAM_A = "0" *) 
  (* C_RSTRAM_B = "0" *) 
  (* C_RST_PRIORITY_A = "CE" *) 
  (* C_RST_PRIORITY_B = "CE" *) 
  (* C_SIM_COLLISION_CHECK = "ALL" *) 
  (* C_USE_BRAM_BLOCK = "1" *) 
  (* C_USE_BYTE_WEA = "1" *) 
  (* C_USE_BYTE_WEB = "1" *) 
  (* C_USE_DEFAULT_DATA = "0" *) 
  (* C_USE_ECC = "0" *) 
  (* C_USE_SOFTECC = "0" *) 
  (* C_USE_URAM = "0" *) 
  (* C_WEA_WIDTH = "4" *) 
  (* C_WEB_WIDTH = "4" *) 
  (* C_WRITE_DEPTH_A = "2048" *) 
  (* C_WRITE_DEPTH_B = "2048" *) 
  (* C_WRITE_MODE_A = "WRITE_FIRST" *) 
  (* C_WRITE_MODE_B = "WRITE_FIRST" *) 
  (* C_WRITE_WIDTH_A = "32" *) 
  (* C_WRITE_WIDTH_B = "32" *) 
  (* C_XDEVICEFAMILY = "artix7" *) 
  (* downgradeipidentifiedwarnings = "yes" *) 
  (* is_du_within_envelope = "true" *) 
  dlembsys_axi_bram_ctrl_0_bram_0_blk_mem_gen_v8_4_5 U0
       (.addra({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,addra[12:2],1'b0,1'b0}),
        .addrb({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,addrb[12:2],1'b0,1'b0}),
        .clka(clka),
        .clkb(clkb),
        .dbiterr(NLW_U0_dbiterr_UNCONNECTED),
        .deepsleep(1'b0),
        .dina(dina),
        .dinb(dinb),
        .douta(douta),
        .doutb(doutb),
        .eccpipece(1'b0),
        .ena(ena),
        .enb(enb),
        .injectdbiterr(1'b0),
        .injectsbiterr(1'b0),
        .rdaddrecc(NLW_U0_rdaddrecc_UNCONNECTED[31:0]),
        .regcea(1'b0),
        .regceb(1'b0),
        .rsta(rsta),
        .rsta_busy(rsta_busy),
        .rstb(rstb),
        .rstb_busy(rstb_busy),
        .s_aclk(1'b0),
        .s_aresetn(1'b0),
        .s_axi_araddr({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .s_axi_arburst({1'b0,1'b0}),
        .s_axi_arid({1'b0,1'b0,1'b0,1'b0}),
        .s_axi_arlen({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .s_axi_arready(NLW_U0_s_axi_arready_UNCONNECTED),
        .s_axi_arsize({1'b0,1'b0,1'b0}),
        .s_axi_arvalid(1'b0),
        .s_axi_awaddr({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .s_axi_awburst({1'b0,1'b0}),
        .s_axi_awid({1'b0,1'b0,1'b0,1'b0}),
        .s_axi_awlen({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .s_axi_awready(NLW_U0_s_axi_awready_UNCONNECTED),
        .s_axi_awsize({1'b0,1'b0,1'b0}),
        .s_axi_awvalid(1'b0),
        .s_axi_bid(NLW_U0_s_axi_bid_UNCONNECTED[3:0]),
        .s_axi_bready(1'b0),
        .s_axi_bresp(NLW_U0_s_axi_bresp_UNCONNECTED[1:0]),
        .s_axi_bvalid(NLW_U0_s_axi_bvalid_UNCONNECTED),
        .s_axi_dbiterr(NLW_U0_s_axi_dbiterr_UNCONNECTED),
        .s_axi_injectdbiterr(1'b0),
        .s_axi_injectsbiterr(1'b0),
        .s_axi_rdaddrecc(NLW_U0_s_axi_rdaddrecc_UNCONNECTED[31:0]),
        .s_axi_rdata(NLW_U0_s_axi_rdata_UNCONNECTED[31:0]),
        .s_axi_rid(NLW_U0_s_axi_rid_UNCONNECTED[3:0]),
        .s_axi_rlast(NLW_U0_s_axi_rlast_UNCONNECTED),
        .s_axi_rready(1'b0),
        .s_axi_rresp(NLW_U0_s_axi_rresp_UNCONNECTED[1:0]),
        .s_axi_rvalid(NLW_U0_s_axi_rvalid_UNCONNECTED),
        .s_axi_sbiterr(NLW_U0_s_axi_sbiterr_UNCONNECTED),
        .s_axi_wdata({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .s_axi_wlast(1'b0),
        .s_axi_wready(NLW_U0_s_axi_wready_UNCONNECTED),
        .s_axi_wstrb({1'b0,1'b0,1'b0,1'b0}),
        .s_axi_wvalid(1'b0),
        .sbiterr(NLW_U0_sbiterr_UNCONNECTED),
        .shutdown(1'b0),
        .sleep(1'b0),
        .wea(wea),
        .web(web));
endmodule
`pragma protect begin_protected
`pragma protect version = 1
`pragma protect encrypt_agent = "XILINX"
`pragma protect encrypt_agent_info = "Xilinx Encryption Tool 2022.2"
`pragma protect key_keyowner="Synopsys", key_keyname="SNPS-VCS-RSA-2", key_method="rsa"
`pragma protect encoding = (enctype="BASE64", line_length=76, bytes=128)
`pragma protect key_block
VHPlDkoDlWlBfBMvPBmGYmaek3s9hXXhjF28kllYPnaNm3TSnzzpXHWHc8Ye9/2L2yiQfJ1hTWou
Ia/zeQ8h9/dtr6QB5YkyW4wlb/LbMgXb+DGIXPSllNl0IMsRQIcQDbcQm1bO/nlhb+2pjxiuaQrl
DbvxoDwPs7z3LunRxsg=

`pragma protect key_keyowner="Aldec", key_keyname="ALDEC15_001", key_method="rsa"
`pragma protect encoding = (enctype="BASE64", line_length=76, bytes=256)
`pragma protect key_block
lmIhoX8hXuc7tNV1sXY1K2/gXL7Y7Hq73qQF7+x03UWWTRd3uhGmVQtOMVbhIW+66UkWUHiD26zL
fzqGor8bgSNGpSFyS11k4TwLQT4OfAMGO8C9Qmmh4+VENBnpS9TW+wHzCv8oUwht7xYtYRZvOvYK
F3fMppz2sBkUd1lciw98ZE/UmNkhqBuMfIYF43j45DEJ55PBhOZNg91Ls4v3qBHyBAaYPFFoMry3
d5Fw1PZyFQSEOSSpwgyds2aN0g6oIwl7zm0LJrM9VDAOxBUE50hk+oHr4jj8J8UhHQJnlEHm1Idm
rvxKygNKRvfSpa90NYxZJFYgqnrMYg+19+9aZA==

`pragma protect key_keyowner="Mentor Graphics Corporation", key_keyname="MGC-VELOCE-RSA", key_method="rsa"
`pragma protect encoding = (enctype="BASE64", line_length=76, bytes=128)
`pragma protect key_block
VkyCjO2onoeZWEoYQ/4ue7X5mkHyTYVW9xjdoTsGS4GdP/Q64VaCZL/jr6R8DVDXPMnH7tRMrDpo
jpYBnyzSgOkfgqM+96ioC2fDyAaG4gYgGLmrBR6qK3/mxXwAZZX+GJ9R/eWXkc9h8xN+gsSSX6/M
jIQCgeT6q7PB4dWT6KY=

`pragma protect key_keyowner="Mentor Graphics Corporation", key_keyname="MGC-VERIF-SIM-RSA-2", key_method="rsa"
`pragma protect encoding = (enctype="BASE64", line_length=76, bytes=256)
`pragma protect key_block
Iub91V+TnhVlZCSLu6iKmFjix71y6/l83OPTs8uewWvkE7WcqYxEKi9fonXEkzAtWzuKwEUqnOlN
VBsNJqPUdKcd22q523mrdt89mpdosWD+hvZdO7ELhJniY5u9h49FFkubpN2JiUTcIcKEYxVNlds4
wyvaYUqbPVH5v2ooJwDdimS4GVn9HerCOgPwfshvQDNlMTxLcYju4v8BHMc5Rub9Q/ihvpQU74v2
ouZ9XIwA+C6pBLwvaqS8jE7HXOokgqJilaX/W/t+KEgiFry/txRTMU9WMD7tCN7lcfjCydmS3Lq+
3u6Hsr0S8BwNjcaDpZDnBTygUJd4JSqREnk33w==

`pragma protect key_keyowner="Real Intent", key_keyname="RI-RSA-KEY-1", key_method="rsa"
`pragma protect encoding = (enctype="BASE64", line_length=76, bytes=256)
`pragma protect key_block
U46EWFmKmpZGaWfyL+dokyQtJtaOYsa7HCW/+fdtw9/yHKTWFpmqKBZngBj5rPkNhtTDDCJkqsYj
tUXg1j4tgIBaCQn9B0q/aG+B3gPLrudp9hLL25mVbsfiTzdekiV2hJMmhuMoavKKPJHC6zyW7kZi
80er82OQy8h+Df/fe6TRjH9xEt3/b80tRKUMbxkLfnnkAyyf1KfOhB6/uyI4mwXuQR+DsAbzybKR
YtXpOiW72tGrXTFlzcwbHamWZefqsilVpBw6V5dh33vYKGx50xwWpj76maAkpQrOpB7zufeldJe4
W1UOEN84AZdRTLkVSxamWo/wp8nP9fiGS/ItRw==

`pragma protect key_keyowner="Xilinx", key_keyname="xilinxt_2021_07", key_method="rsa"
`pragma protect encoding = (enctype="BASE64", line_length=76, bytes=256)
`pragma protect key_block
qczgIJYpE/SzErzK7eWJBGcDFEzDLm8cKbwJbPXuM6YnJxx44W+E60R3war7K2QGFAkOoCDUtDC7
SghJGF32btaDLzeKm0tQ669sBtQmMIaBrlt7I9QBkNM8zN9GL92qxNC9o3UVWMOYy5BmH8nUPgcE
O6lRubeltlrTuDe7UJQ2nEPHcXjpUJJ8dxktyW+LovBy1OxW8g4GRAsmEJsoOEg0HuDdWcc4IshJ
PvwPJ7LblELAKsdkSt65y9VaklaEm7MlH4ImlgIa74TgRmutLUbWxM1QYhGE5rAzFhGU5i3RJOdx
L3N7GGGvLMW2z9NSHbIFX+/eNII9fNJ9nZbgLA==

`pragma protect key_keyowner="Metrics Technologies Inc.", key_keyname="DSim", key_method="rsa"
`pragma protect encoding = (enctype="BASE64", line_length=76, bytes=256)
`pragma protect key_block
Ti1NUgDv8YPk90APMwfu/mRr38QYwAxZfv0T6zQ89YS55t2EquEGVqrEafYX6rTydLOw8le1Oucv
f2oERpSSSTih/ScZneSZmuPE/Zh2BU1Ajv0j+/+0uEWXU+5lLPbDJjnapTmJXih1MYPf0SHpZZmE
BKj2IEBI9MPZlh6bxpa5BWJnyPdAvHf+UNaMXU9+pmbtrzUVebql4mFJu45Z3+ehmFY4FBW3zXMF
44C4TlHACLwL3vHVMCVfeKhgdVDbpE+/IFhTStz7mZ9h9RKGanQcs6YDVM1R+2RKA1QT1fX4FiQc
1V+FGmrm1ujxmFGXwpfNKByVlfCY0oWhRJCYYQ==

`pragma protect key_keyowner="Atrenta", key_keyname="ATR-SG-RSA-1", key_method="rsa"
`pragma protect encoding = (enctype="BASE64", line_length=76, bytes=384)
`pragma protect key_block
HuEXFK0NXt09xU2yxxjng1OLsT+ZEM4EhqBgpr9D2ljw2vDaMBrqEsRQTc2B9soDq3ewDduHJXBd
OGYxkPnoN6LhjULtB2nTgjcH6NxA4puZ1ZNcndDndVBo8rTW5W1OqHq6InAG0CqPpTIkuqz3ECPl
EysI++MCDfH6tIzlekxJFIJ1McJsTq5rFuLzMMcrmkBxgcayDpOcCFuzZzCczxmt/cCCIKmDybwT
OQXmOcLJoYLP4sFu6R9c6xO8i6p++crv2N3eIxZHKbek9xBBZqQM9EYuEtsbkqAs9XZpa16i5njR
BDFxTKcP6r7JgFALJE89AZhBbate5JXWp0v4ECZD18aEL17CipwcWPutNMdG1apzSPP5y59n7rMG
yxBPz1gKHc3Emkl4WcO0hjICxqmO6dMXoY8JvBSf6ry2l0sH9Ihr3Bq5WWmlhPHnoaNr5jl//vNe
KfToWtn97eoVSt1LnmXXnSpdigbHr0UIg8AdkpdkuNRaWdVicDdgSo49

`pragma protect key_keyowner="Cadence Design Systems.", key_keyname="CDS_RSA_KEY_VER_1", key_method="rsa"
`pragma protect encoding = (enctype="BASE64", line_length=76, bytes=256)
`pragma protect key_block
mokwst2bn6UxD6V9UdIgCIG1QQ/d0FiJqYGOTI2eHPV6YElaLjnJ8DnQmZnGS95o3x93FDOoa58C
RwYsX1fVoVtXkj1LuZq0k7q9vEe4T8xMjpkeYtIHY9k0Xhy1Lq/xRlfzGAf9fvf9e+f4r7aR/Sb/
uCZxxugG5niTwLENY1n3NthYL0jvo8Fmdw4Qg0nTCGWlVCws+09K0g9/lx6I9EcuHHemcHO3fOZG
lMc4NaPNozKwnyDMoWUkwiVxyFEPFaQLNYqzjvR+CqrWfhFLo96JWhL+eaDoNuZoBVYQtNH5ZwBL
BoO27Pw10lgcReGlZBz3BLO7T4ddynCx0+eSnw==

`pragma protect key_keyowner="Synplicity", key_keyname="SYNP15_1", key_method="rsa"
`pragma protect encoding = (enctype="BASE64", line_length=76, bytes=256)
`pragma protect key_block
PiP7AjOQqqouyQMoBQqgWIDhUSViq94rIvGiIJ/UKMDspM/yXw1caE8AhWHTjYckC4yLpPAz5P6s
1Z6flzDPrzVwg4e59X2cc4IMCHhedna0rDO804njcc6amRDTeLsMLTkWfvomB4xwszm2AgT+PRnB
WHd09ZUDVFjiBXT+Oa9AicgGJHrX3w823yBPuAa704kje/SzgtiDpcTU1eLmLhLW7LpEd9KIHd9s
ER7Uk9Orws0Kq9PMTqMX4hMn5K5mFakOeOURiEbUjdv5RiIJ2g/PlQXSItM8fHsBTQa6fOaJwQTI
vHwK3a8ZBHpfT1YH+n7wNiNUZwD4SFXm1QVx4g==

`pragma protect key_keyowner="Mentor Graphics Corporation", key_keyname="MGC-PREC-RSA", key_method="rsa"
`pragma protect encoding = (enctype="BASE64", line_length=76, bytes=256)
`pragma protect key_block
Ul5ZfTHJwMctaNhYRortUZizYMPYRef7uYqPSuMkxsArnxI/cjGh+KRMwzV86hyp/6TXSJIjm5ec
2wX2UONdPN+DOJ84jYC4JbgJQrPnTj7ioD8uLX/WlyPcQzyF5keqFgj5eR5s13FskVWCuAWf5m9w
mhFEKFjVXDAr7gVgAJh/hL8P6Psrnf+LGfiM8JhnDepsHEYykGlpD3fzru2BGgqHWqPqFMcnyVGl
vysaIXiJz/eYKvO8RGcgd3DJAM/wPm9A0m/DWcmSnczOgTjoqkHcBg2H5uJMLvufzmjImi6LYEqq
v04ESDEN31cSUzqUYcayvMFOnI/WNsWbFIa5+Q==

`pragma protect data_method = "AES128-CBC"
`pragma protect encoding = (enctype = "BASE64", line_length = 76, bytes = 60032)
`pragma protect data_block
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
CNKg6zo3VdMnwgE=
`pragma protect end_protected
`ifndef GLBL
`define GLBL
`timescale  1 ps / 1 ps

module glbl ();

    parameter ROC_WIDTH = 100000;
    parameter TOC_WIDTH = 0;
    parameter GRES_WIDTH = 10000;
    parameter GRES_START = 10000;

//--------   STARTUP Globals --------------
    wire GSR;
    wire GTS;
    wire GWE;
    wire PRLD;
    wire GRESTORE;
    tri1 p_up_tmp;
    tri (weak1, strong0) PLL_LOCKG = p_up_tmp;

    wire PROGB_GLBL;
    wire CCLKO_GLBL;
    wire FCSBO_GLBL;
    wire [3:0] DO_GLBL;
    wire [3:0] DI_GLBL;
   
    reg GSR_int;
    reg GTS_int;
    reg PRLD_int;
    reg GRESTORE_int;

//--------   JTAG Globals --------------
    wire JTAG_TDO_GLBL;
    wire JTAG_TCK_GLBL;
    wire JTAG_TDI_GLBL;
    wire JTAG_TMS_GLBL;
    wire JTAG_TRST_GLBL;

    reg JTAG_CAPTURE_GLBL;
    reg JTAG_RESET_GLBL;
    reg JTAG_SHIFT_GLBL;
    reg JTAG_UPDATE_GLBL;
    reg JTAG_RUNTEST_GLBL;

    reg JTAG_SEL1_GLBL = 0;
    reg JTAG_SEL2_GLBL = 0 ;
    reg JTAG_SEL3_GLBL = 0;
    reg JTAG_SEL4_GLBL = 0;

    reg JTAG_USER_TDO1_GLBL = 1'bz;
    reg JTAG_USER_TDO2_GLBL = 1'bz;
    reg JTAG_USER_TDO3_GLBL = 1'bz;
    reg JTAG_USER_TDO4_GLBL = 1'bz;

    assign (strong1, weak0) GSR = GSR_int;
    assign (strong1, weak0) GTS = GTS_int;
    assign (weak1, weak0) PRLD = PRLD_int;
    assign (strong1, weak0) GRESTORE = GRESTORE_int;

    initial begin
	GSR_int = 1'b1;
	PRLD_int = 1'b1;
	#(ROC_WIDTH)
	GSR_int = 1'b0;
	PRLD_int = 1'b0;
    end

    initial begin
	GTS_int = 1'b1;
	#(TOC_WIDTH)
	GTS_int = 1'b0;
    end

    initial begin 
	GRESTORE_int = 1'b0;
	#(GRES_START);
	GRESTORE_int = 1'b1;
	#(GRES_WIDTH);
	GRESTORE_int = 1'b0;
    end

endmodule
`endif
