# Copyright (C) 2012-2020 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)
#
# SPDX-License-Identifier: MIT
#

include linux-google.inc

SUMMARY = "Real-Time Linux kernel for Google boards"

LOCALVERSION = "google-rt"

SRC_URI += " file://patch-5.4.84-rt47.patch"

KCONF_BSP_AUDIT_LEVEL = "2"
LINUX_KERNEL_TYPE = "preempt-rt"

COMPATIBLE_MACHINE = "(coral-dev)"
