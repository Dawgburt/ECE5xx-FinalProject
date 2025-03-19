# 
# Usage: To re-create this platform project launch xsct with below options.
# xsct C:\SimpleLock\Vitis9\DLplatform9\platform.tcl
# 
# OR launch xsct and run below command.
# source C:\SimpleLock\Vitis9\DLplatform9\platform.tcl
# 
# To create the platform in a different location, modify the -out option of "platform create" command.
# -out option specifies the output directory of the platform project.

platform create -name {DLplatform9}\
-hw {C:\SimpleLock\Vivado9\embsys9_wrapper.xsa}\
-proc {microblaze_0} -os {standalone} -out {C:/SimpleLock/Vitis9}

platform write
platform generate -domains 
platform active {DLplatform9}
bsp reload
platform generate
bsp config stdin "mdm_1"
bsp config stdout "mdm_1"
bsp write
bsp reload
catch {bsp regenerate}
platform generate -domains standalone_domain 
platform clean
platform generate
platform clean
platform clean
platform clean
platform generate
platform active {DLplatform9}
platform config -updatehw {C:/SimpleLock/Vivado9/embsys9_wrapper.xsa}
platform generate -domains 
bsp reload
bsp reload
platform generate -domains 
