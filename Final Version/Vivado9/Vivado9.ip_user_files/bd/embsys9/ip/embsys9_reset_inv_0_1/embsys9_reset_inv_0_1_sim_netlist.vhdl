-- Copyright 1986-2022 Xilinx, Inc. All Rights Reserved.
-- --------------------------------------------------------------------------------
-- Tool Version: Vivado v.2022.2 (win64) Build 3671981 Fri Oct 14 05:00:03 MDT 2022
-- Date        : Tue Mar 18 14:17:35 2025
-- Host        : Dawgburts-Mothership running 64-bit major release  (build 9200)
-- Command     : write_vhdl -force -mode funcsim -rename_top embsys9_reset_inv_0_1 -prefix
--               embsys9_reset_inv_0_1_ embsys9_reset_inv_0_0_sim_netlist.vhdl
-- Design      : embsys9_reset_inv_0_0
-- Purpose     : This VHDL netlist is a functional simulation representation of the design and should not be modified or
--               synthesized. This netlist cannot be used for SDF annotated simulation.
-- Device      : xc7a100tcsg324-1
-- --------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
library UNISIM;
use UNISIM.VCOMPONENTS.ALL;
entity embsys9_reset_inv_0_1 is
  port (
    Op1 : in STD_LOGIC_VECTOR ( 0 to 0 );
    Res : out STD_LOGIC_VECTOR ( 0 to 0 )
  );
  attribute NotValidForBitStream : boolean;
  attribute NotValidForBitStream of embsys9_reset_inv_0_1 : entity is true;
  attribute CHECK_LICENSE_TYPE : string;
  attribute CHECK_LICENSE_TYPE of embsys9_reset_inv_0_1 : entity is "embsys9_reset_inv_0_0,util_vector_logic_v2_0_2_util_vector_logic,{}";
  attribute DowngradeIPIdentifiedWarnings : string;
  attribute DowngradeIPIdentifiedWarnings of embsys9_reset_inv_0_1 : entity is "yes";
  attribute X_CORE_INFO : string;
  attribute X_CORE_INFO of embsys9_reset_inv_0_1 : entity is "util_vector_logic_v2_0_2_util_vector_logic,Vivado 2022.2";
end embsys9_reset_inv_0_1;

architecture STRUCTURE of embsys9_reset_inv_0_1 is
begin
\Res[0]_INST_0\: unisim.vcomponents.LUT1
    generic map(
      INIT => X"1"
    )
        port map (
      I0 => Op1(0),
      O => Res(0)
    );
end STRUCTURE;
