# Usage with Vitis IDE:
# In Vitis IDE create a Single Application Debug launch configuration,
# change the debug type to 'Attach to running target' and provide this 
# tcl script in 'Execute Script' option.
# Path of this script: C:\SimpleLock\DigitalLockv2Vitis\DLapplication_system\_ide\scripts\systemdebugger_dlapplication_system_standalone.tcl
# 
# 
# Usage with xsct:
# To debug using xsct, launch xsct and run below command
# source C:\SimpleLock\DigitalLockv2Vitis\DLapplication_system\_ide\scripts\systemdebugger_dlapplication_system_standalone.tcl
# 
connect -url tcp:127.0.0.1:3121
targets -set -filter {jtag_cable_name =~ "Digilent Nexys A7 -100T 210292BB2FBAA" && level==0 && jtag_device_ctx=="jsn-Nexys A7 -100T-210292BB2FBAA-13631093-0"}
fpga -file C:/SimpleLock/DigitalLockv2Vitis/DLapplication/_ide/bitstream/download.bit
targets -set -nocase -filter {name =~ "*microblaze*#0" && bscan=="USER2" }
loadhw -hw C:/SimpleLock/DigitalLockv2Vitis/DLplatform/export/DLplatform/hw/DLembsys.xsa -regs
configparams mdm-detect-bscan-mask 2
targets -set -nocase -filter {name =~ "*microblaze*#0" && bscan=="USER2" }
rst -system
after 3000
targets -set -nocase -filter {name =~ "*microblaze*#0" && bscan=="USER2" }
dow C:/SimpleLock/DigitalLockv2Vitis/DLapplication/Debug/DLapplication.elf
targets -set -nocase -filter {name =~ "*microblaze*#0" && bscan=="USER2" }
con
