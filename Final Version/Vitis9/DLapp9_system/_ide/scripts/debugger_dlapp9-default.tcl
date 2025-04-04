# Usage with Vitis IDE:
# In Vitis IDE create a Single Application Debug launch configuration,
# change the debug type to 'Attach to running target' and provide this 
# tcl script in 'Execute Script' option.
# Path of this script: C:\SimpleLock\Vitis9\DLapp9_system\_ide\scripts\debugger_dlapp9-default.tcl
# 
# 
# Usage with xsct:
# To debug using xsct, launch xsct and run below command
# source C:\SimpleLock\Vitis9\DLapp9_system\_ide\scripts\debugger_dlapp9-default.tcl
# 
connect -url tcp:127.0.0.1:3121
targets -set -filter {jtag_cable_name =~ "Digilent Nexys A7 -100T 210292BB2FBAA" && level==0 && jtag_device_ctx=="jsn-Nexys A7 -100T-210292BB2FBAA-13631093-0"}
fpga -file C:/SimpleLock/Vitis9/DLapp9/_ide/bitstream/download.bit
targets -set -nocase -filter {name =~ "*microblaze*#0" && bscan=="USER2" }
loadhw -hw C:/SimpleLock/Vitis9/DLplatform9/export/DLplatform9/hw/embsys9_wrapper.xsa -regs
configparams mdm-detect-bscan-mask 2
targets -set -nocase -filter {name =~ "*microblaze*#0" && bscan=="USER2" }
rst -system
after 3000
targets -set -nocase -filter {name =~ "*microblaze*#0" && bscan=="USER2" }
dow C:/SimpleLock/Vitis9/DLapp9/Debug/DLapp9.elf
targets -set -nocase -filter {name =~ "*microblaze*#0" && bscan=="USER2" }
con
