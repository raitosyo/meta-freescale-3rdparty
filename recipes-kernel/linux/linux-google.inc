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
SRCREV = "300fb8ccf767c216e262cfc8e6efab2cce7e9b13"
LINUX_VERSION = "5.4.84"
