vlib modelsim_lib/work
vlib modelsim_lib/msim

vlib modelsim_lib/msim/xpm
vlib modelsim_lib/msim/microblaze_v11_0_10
vlib modelsim_lib/msim/xil_defaultlib
vlib modelsim_lib/msim/lmb_v10_v3_0_12
vlib modelsim_lib/msim/lmb_bram_if_cntlr_v4_0_21
vlib modelsim_lib/msim/blk_mem_gen_v8_4_5
vlib modelsim_lib/msim/generic_baseblocks_v2_1_0
vlib modelsim_lib/msim/axi_infrastructure_v1_1_0
vlib modelsim_lib/msim/axi_register_slice_v2_1_27
vlib modelsim_lib/msim/fifo_generator_v13_2_7
vlib modelsim_lib/msim/axi_data_fifo_v2_1_26
vlib modelsim_lib/msim/axi_crossbar_v2_1_28
vlib modelsim_lib/msim/axi_lite_ipif_v3_0_4
vlib modelsim_lib/msim/mdm_v3_2_23
vlib modelsim_lib/msim/lib_cdc_v1_0_2
vlib modelsim_lib/msim/proc_sys_reset_v5_0_13
vlib modelsim_lib/msim/lib_pkg_v1_0_2
vlib modelsim_lib/msim/lib_srl_fifo_v1_0_2
vlib modelsim_lib/msim/axi_uartlite_v2_0_31
vlib modelsim_lib/msim/axi_bram_ctrl_v4_1_7
vlib modelsim_lib/msim/util_vector_logic_v2_0_2
vlib modelsim_lib/msim/axi_protocol_converter_v2_1_27

vmap xpm modelsim_lib/msim/xpm
vmap microblaze_v11_0_10 modelsim_lib/msim/microblaze_v11_0_10
vmap xil_defaultlib modelsim_lib/msim/xil_defaultlib
vmap lmb_v10_v3_0_12 modelsim_lib/msim/lmb_v10_v3_0_12
vmap lmb_bram_if_cntlr_v4_0_21 modelsim_lib/msim/lmb_bram_if_cntlr_v4_0_21
vmap blk_mem_gen_v8_4_5 modelsim_lib/msim/blk_mem_gen_v8_4_5
vmap generic_baseblocks_v2_1_0 modelsim_lib/msim/generic_baseblocks_v2_1_0
vmap axi_infrastructure_v1_1_0 modelsim_lib/msim/axi_infrastructure_v1_1_0
vmap axi_register_slice_v2_1_27 modelsim_lib/msim/axi_register_slice_v2_1_27
vmap fifo_generator_v13_2_7 modelsim_lib/msim/fifo_generator_v13_2_7
vmap axi_data_fifo_v2_1_26 modelsim_lib/msim/axi_data_fifo_v2_1_26
vmap axi_crossbar_v2_1_28 modelsim_lib/msim/axi_crossbar_v2_1_28
vmap axi_lite_ipif_v3_0_4 modelsim_lib/msim/axi_lite_ipif_v3_0_4
vmap mdm_v3_2_23 modelsim_lib/msim/mdm_v3_2_23
vmap lib_cdc_v1_0_2 modelsim_lib/msim/lib_cdc_v1_0_2
vmap proc_sys_reset_v5_0_13 modelsim_lib/msim/proc_sys_reset_v5_0_13
vmap lib_pkg_v1_0_2 modelsim_lib/msim/lib_pkg_v1_0_2
vmap lib_srl_fifo_v1_0_2 modelsim_lib/msim/lib_srl_fifo_v1_0_2
vmap axi_uartlite_v2_0_31 modelsim_lib/msim/axi_uartlite_v2_0_31
vmap axi_bram_ctrl_v4_1_7 modelsim_lib/msim/axi_bram_ctrl_v4_1_7
vmap util_vector_logic_v2_0_2 modelsim_lib/msim/util_vector_logic_v2_0_2
vmap axi_protocol_converter_v2_1_27 modelsim_lib/msim/axi_protocol_converter_v2_1_27

vlog -work xpm  -incr -mfcu  -sv "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl" "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/7698" \
"C:/Xilinx/Vivado/2022.2/data/ip/xpm/xpm_cdc/hdl/xpm_cdc.sv" \
"C:/Xilinx/Vivado/2022.2/data/ip/xpm/xpm_memory/hdl/xpm_memory.sv" \

vcom -work xpm  -93  \
"C:/Xilinx/Vivado/2022.2/data/ip/xpm/xpm_VCOMP.vhd" \

vcom -work microblaze_v11_0_10  -93  \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/1f7b/hdl/microblaze_v11_0_vh_rfs.vhd" \

vcom -work xil_defaultlib  -93  \
"../../../bd/dlembsys/ip/dlembsys_microblaze_0_0/sim/dlembsys_microblaze_0_0.vhd" \

vcom -work lmb_v10_v3_0_12  -93  \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/cd1d/hdl/lmb_v10_v3_0_vh_rfs.vhd" \

vcom -work xil_defaultlib  -93  \
"../../../bd/dlembsys/ip/dlembsys_dlmb_v10_0/sim/dlembsys_dlmb_v10_0.vhd" \
"../../../bd/dlembsys/ip/dlembsys_ilmb_v10_0/sim/dlembsys_ilmb_v10_0.vhd" \

vcom -work lmb_bram_if_cntlr_v4_0_21  -93  \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/a177/hdl/lmb_bram_if_cntlr_v4_0_vh_rfs.vhd" \

vcom -work xil_defaultlib  -93  \
"../../../bd/dlembsys/ip/dlembsys_dlmb_bram_if_cntlr_0/sim/dlembsys_dlmb_bram_if_cntlr_0.vhd" \
"../../../bd/dlembsys/ip/dlembsys_ilmb_bram_if_cntlr_0/sim/dlembsys_ilmb_bram_if_cntlr_0.vhd" \

vlog -work blk_mem_gen_v8_4_5  -incr -mfcu  "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl" "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/7698" \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/25a8/simulation/blk_mem_gen_v8_4.v" \

vlog -work xil_defaultlib  -incr -mfcu  "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl" "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/7698" \
"../../../bd/dlembsys/ip/dlembsys_lmb_bram_0/sim/dlembsys_lmb_bram_0.v" \

vlog -work generic_baseblocks_v2_1_0  -incr -mfcu  "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl" "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/7698" \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/b752/hdl/generic_baseblocks_v2_1_vl_rfs.v" \

vlog -work axi_infrastructure_v1_1_0  -incr -mfcu  "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl" "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/7698" \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl/axi_infrastructure_v1_1_vl_rfs.v" \

vlog -work axi_register_slice_v2_1_27  -incr -mfcu  "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl" "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/7698" \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/f0b4/hdl/axi_register_slice_v2_1_vl_rfs.v" \

vlog -work fifo_generator_v13_2_7  -incr -mfcu  "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl" "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/7698" \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/83df/simulation/fifo_generator_vlog_beh.v" \

vcom -work fifo_generator_v13_2_7  -93  \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/83df/hdl/fifo_generator_v13_2_rfs.vhd" \

vlog -work fifo_generator_v13_2_7  -incr -mfcu  "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl" "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/7698" \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/83df/hdl/fifo_generator_v13_2_rfs.v" \

vlog -work axi_data_fifo_v2_1_26  -incr -mfcu  "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl" "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/7698" \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/3111/hdl/axi_data_fifo_v2_1_vl_rfs.v" \

vlog -work axi_crossbar_v2_1_28  -incr -mfcu  "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl" "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/7698" \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/c40e/hdl/axi_crossbar_v2_1_vl_rfs.v" \

vlog -work xil_defaultlib  -incr -mfcu  "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl" "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/7698" \
"../../../bd/dlembsys/ip/dlembsys_xbar_0/sim/dlembsys_xbar_0.v" \

vcom -work axi_lite_ipif_v3_0_4  -93  \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/66ea/hdl/axi_lite_ipif_v3_0_vh_rfs.vhd" \

vcom -work mdm_v3_2_23  -93  \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/b8f4/hdl/mdm_v3_2_vh_rfs.vhd" \

vcom -work xil_defaultlib  -93  \
"../../../bd/dlembsys/ip/dlembsys_mdm_1_0/sim/dlembsys_mdm_1_0.vhd" \

vlog -work xil_defaultlib  -incr -mfcu  "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl" "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/7698" \
"../../../bd/dlembsys/ip/dlembsys_clk_wiz_1_0/dlembsys_clk_wiz_1_0_clk_wiz.v" \
"../../../bd/dlembsys/ip/dlembsys_clk_wiz_1_0/dlembsys_clk_wiz_1_0.v" \

vcom -work lib_cdc_v1_0_2  -93  \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ef1e/hdl/lib_cdc_v1_0_rfs.vhd" \

vcom -work proc_sys_reset_v5_0_13  -93  \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/8842/hdl/proc_sys_reset_v5_0_vh_rfs.vhd" \

vcom -work xil_defaultlib  -93  \
"../../../bd/dlembsys/ip/dlembsys_rst_clk_wiz_1_100M_0/sim/dlembsys_rst_clk_wiz_1_100M_0.vhd" \

vcom -work lib_pkg_v1_0_2  -93  \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/0513/hdl/lib_pkg_v1_0_rfs.vhd" \

vcom -work lib_srl_fifo_v1_0_2  -93  \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/51ce/hdl/lib_srl_fifo_v1_0_rfs.vhd" \

vcom -work axi_uartlite_v2_0_31  -93  \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/67a1/hdl/axi_uartlite_v2_0_vh_rfs.vhd" \

vcom -work xil_defaultlib  -93  \
"../../../bd/dlembsys/ip/dlembsys_axi_uartlite_0_1/sim/dlembsys_axi_uartlite_0_1.vhd" \

vcom -work axi_bram_ctrl_v4_1_7  -93  \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/f80b/hdl/axi_bram_ctrl_v4_1_rfs.vhd" \

vcom -work xil_defaultlib  -93  \
"../../../bd/dlembsys/ip/dlembsys_axi_bram_ctrl_0_0/sim/dlembsys_axi_bram_ctrl_0_0.vhd" \

vlog -work xil_defaultlib  -incr -mfcu  "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl" "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/7698" \
"../../../bd/dlembsys/ip/dlembsys_axi_bram_ctrl_0_bram_0/sim/dlembsys_axi_bram_ctrl_0_bram_0.v" \

vlog -work util_vector_logic_v2_0_2  -incr -mfcu  "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl" "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/7698" \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/3d84/hdl/util_vector_logic_v2_0_vl_rfs.v" \

vlog -work xil_defaultlib  -incr -mfcu  "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl" "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/7698" \
"../../../bd/dlembsys/ip/dlembsys_reset_inv_0_0/sim/dlembsys_reset_inv_0_0.v" \
"../../../bd/dlembsys/sim/dlembsys.v" \

vlog -work axi_protocol_converter_v2_1_27  -incr -mfcu  "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl" "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/7698" \
"../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/aeb3/hdl/axi_protocol_converter_v2_1_vl_rfs.v" \

vlog -work xil_defaultlib  -incr -mfcu  "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/ec67/hdl" "+incdir+../../../../DigitalLockv2.gen/sources_1/bd/dlembsys/ipshared/7698" \
"../../../bd/dlembsys/ip/dlembsys_auto_pc_2/sim/dlembsys_auto_pc_2.v" \
"../../../bd/dlembsys/ip/dlembsys_auto_pc_0/sim/dlembsys_auto_pc_0.v" \
"../../../bd/dlembsys/ip/dlembsys_auto_pc_1/sim/dlembsys_auto_pc_1.v" \

vlog -work xil_defaultlib \
"glbl.v"

