#!/usr/bin/python3
#
# trace_sys_write.py
#
# Demonstrates stateful sys_write system call recording along with the
# associated PID of the userspace process that requested the sys_write system call.
# 
# Copyright (c) 2022 Huzaifa Patel.
#
# Author(s):
#   Huzaifa Patel <huzaifa.patel@carleton.ca>

from __future__ import print_function
from bcc import BPF
import time

def trace_write_syscall():

    # Load BPF program
    trace_point = BPF(text="""

    TRACEPOINT_PROBE(syscalls, sys_enter_write) {
        bpf_trace_printk("sys_write(fd: %lu, buf: %lx, count: %lu)", args->fd, args->buf, args->count);
    }

    """, cflags=["-Wno-macro-redefined", "-Wno-return-type"])

    # Header
    print("%-11s %-20s %-8s %s\n" % ("TIME", "PROGRAM", "PID", "FUNCTION CALL"))

    # Format Output
    while 1:
        try:
            (task, pid, cpu, flags, ts, msg) = trace_point.trace_fields()
        except ValueError:
            continue
        time.sleep(1)
        print("%-3f %-20s %-8d %s" % (ts, task.decode('utf-8'), pid, msg.decode('utf-8')))


# TODO - Part A: Question 7 
# WRITE YOUR CODE IN THE FUNCTION BELOW:
def trace_open_syscall():
        print("")


# Try uncommenting the call to trace_write_syscall() if you want to test trace_open_syscall()
def main():
    trace_write_syscall()
    trace_open_syscall()


main()

