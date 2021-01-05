# Copyright (C) 2012-2020 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)
#
# SPDX-License-Identifier: MIT
#

require recipes-kernel/linux/linux-imx.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

DEPENDS += "lzop-native bc-native"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/raitosyo/linux-coral;protocol=https;branch=${SRCBRANCH} \
           file://defconfig"

SRCBRANCH = "5.4-2.1.x-imx-coral"
SRCREV = "71e58a267131a7ca719c647c7ec2be002010d5c6"
LINUX_VERSION = "5.4.84"
