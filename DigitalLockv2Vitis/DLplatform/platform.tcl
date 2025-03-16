# 
# Usage: To re-create this platform project launch xsct with below options.
# xsct C:\SimpleLock\DigitalLockv2Vitis\DLplatform\platform.tcl
# 
# OR launch xsct and run below command.
# source C:\SimpleLock\DigitalLockv2Vitis\DLplatform\platform.tcl
# 
# To create the platform in a different location, modify the -out option of "platform create" command.
# -out option specifies the output directory of the platform project.

platform create -name {DLplatform}\
-hw {C:\SimpleLock\DLembsys.xsa}\
-proc {microblaze_0} -os {standalone} -out {C:/SimpleLock/DigitalLockv2Vitis}

platform write
platform generate -domains 
platform active {DLplatform}
bsp reload
bsp config stdin "mdm_1"
bsp config stdout "mdm_1"
bsp write
bsp reload
catch {bsp regenerate}
platform generate
platform clean
platform generate
