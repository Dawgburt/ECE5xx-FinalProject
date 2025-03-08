-- Copyright 1986-2022 Xilinx, Inc. All Rights Reserved.
-- --------------------------------------------------------------------------------
-- Tool Version: Vivado v.2022.2 (win64) Build 3671981 Fri Oct 14 05:00:03 MDT 2022
-- Date        : Thu Mar  6 11:42:41 2025
-- Host        : Dawgburts-Mothership running 64-bit major release  (build 9200)
-- Command     : write_vhdl -force -mode funcsim -rename_top decalper_eb_ot_sdeen_pot_pi_dehcac_xnilix -prefix
--               decalper_eb_ot_sdeen_pot_pi_dehcac_xnilix_ embsys_inv_shift_rows_0_0_sim_netlist.vhdl
-- Design      : embsys_inv_shift_rows_0_0
-- Purpose     : This VHDL netlist is a functional simulation representation of the design and should not be modified or
--               synthesized. This netlist cannot be used for SDF annotated simulation.
-- Device      : xc7a100tcsg324-1
-- --------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
library UNISIM;
use UNISIM.VCOMPONENTS.ALL;
entity decalper_eb_ot_sdeen_pot_pi_dehcac_xnilix is
  port (
    state : in STD_LOGIC_VECTOR ( 127 downto 0 );
    new_state : out STD_LOGIC_VECTOR ( 127 downto 0 )
  );
  attribute NotValidForBitStream : boolean;
  attribute NotValidForBitStream of decalper_eb_ot_sdeen_pot_pi_dehcac_xnilix : entity is true;
  attribute CHECK_LICENSE_TYPE : string;
  attribute CHECK_LICENSE_TYPE of decalper_eb_ot_sdeen_pot_pi_dehcac_xnilix : entity is "embsys_inv_shift_rows_0_0,inv_shift_rows,{}";
  attribute DowngradeIPIdentifiedWarnings : string;
  attribute DowngradeIPIdentifiedWarnings of decalper_eb_ot_sdeen_pot_pi_dehcac_xnilix : entity is "yes";
  attribute IP_DEFINITION_SOURCE : string;
  attribute IP_DEFINITION_SOURCE of decalper_eb_ot_sdeen_pot_pi_dehcac_xnilix : entity is "module_ref";
  attribute X_CORE_INFO : string;
  attribute X_CORE_INFO of decalper_eb_ot_sdeen_pot_pi_dehcac_xnilix : entity is "inv_shift_rows,Vivado 2022.2";
end decalper_eb_ot_sdeen_pot_pi_dehcac_xnilix;

architecture STRUCTURE of decalper_eb_ot_sdeen_pot_pi_dehcac_xnilix is
  signal \^state\ : STD_LOGIC_VECTOR ( 127 downto 0 );
begin
  \^state\(127 downto 0) <= state(127 downto 0);
  new_state(127 downto 120) <= \^state\(127 downto 120);
  new_state(119 downto 112) <= \^state\(87 downto 80);
  new_state(111 downto 104) <= \^state\(47 downto 40);
  new_state(103 downto 96) <= \^state\(7 downto 0);
  new_state(95 downto 88) <= \^state\(95 downto 88);
  new_state(87 downto 80) <= \^state\(55 downto 48);
  new_state(79 downto 72) <= \^state\(15 downto 8);
  new_state(71 downto 64) <= \^state\(103 downto 96);
  new_state(63 downto 56) <= \^state\(63 downto 56);
  new_state(55 downto 48) <= \^state\(23 downto 16);
  new_state(47 downto 40) <= \^state\(111 downto 104);
  new_state(39 downto 32) <= \^state\(71 downto 64);
  new_state(31 downto 24) <= \^state\(31 downto 24);
  new_state(23 downto 16) <= \^state\(119 downto 112);
  new_state(15 downto 8) <= \^state\(79 downto 72);
  new_state(7 downto 0) <= \^state\(39 downto 32);
end STRUCTURE;
