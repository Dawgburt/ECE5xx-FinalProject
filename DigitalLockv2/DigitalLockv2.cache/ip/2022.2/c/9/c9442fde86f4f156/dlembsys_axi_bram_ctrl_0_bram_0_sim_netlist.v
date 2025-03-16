// Copyright 1986-2022 Xilinx, Inc. All Rights Reserved.
// --------------------------------------------------------------------------------
// Tool Version: Vivado v.2022.2 (win64) Build 3671981 Fri Oct 14 05:00:03 MDT 2022
// Date        : Sun Mar 16 11:42:58 2025
// Host        : Dawgburts-Mothership running 64-bit major release  (build 9200)
// Command     : write_verilog -force -mode funcsim -rename_top decalper_eb_ot_sdeen_pot_pi_dehcac_xnilix -prefix
//               decalper_eb_ot_sdeen_pot_pi_dehcac_xnilix_ dlembsys_axi_bram_ctrl_0_bram_0_sim_netlist.v
// Design      : dlembsys_axi_bram_ctrl_0_bram_0
// Purpose     : This verilog netlist is a functional simulation representation of the design and should not be modified
//               or synthesized. This netlist cannot be used for SDF annotated simulation.
// Device      : xc7a100tcsg324-1
// --------------------------------------------------------------------------------
`timescale 1 ps / 1 ps

(* CHECK_LICENSE_TYPE = "dlembsys_axi_bram_ctrl_0_bram_0,blk_mem_gen_v8_4_5,{}" *) (* downgradeipidentifiedwarnings = "yes" *) (* x_core_info = "blk_mem_gen_v8_4_5,Vivado 2022.2" *) 
(* NotValidForBitStream *)
module decalper_eb_ot_sdeen_pot_pi_dehcac_xnilix
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
  decalper_eb_ot_sdeen_pot_pi_dehcac_xnilix_blk_mem_gen_v8_4_5 U0
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
`pragma protect encoding = (enctype = "BASE64", line_length = 76, bytes = 59888)
`pragma protect data_block
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
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
