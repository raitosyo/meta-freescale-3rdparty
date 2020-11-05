# Copyright (C) 2012-2020 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)
#
# SPDX-License-Identifier: MIT
#

require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for Google boards"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

DEPENDS += "lzop-native bc-native"

S = "${WORKDIR}/git"

SRCBRANCH = "WIP_google-5.4-2.1.x-imx"
SRCREV = "${AUTOREV}"

LINUX_VERSION = "5.4.74"
LOCALVERSION = "-google"

SRC_URI = "git://github.com/raitosyo/linux-coral;protocol=https;branch=${SRCBRANCH} \
           file://defconfig"

COMPATIBLE_MACHINE = "(coral-dev)"

do_configure_prepend() {
    for f in ${B}/../*.cfg; do
        [ -e "$f" ] && cat $f >> ${B}/.config
    done
}

SRC_URI_append_coral-dev = " \
    file://defconfig.coral-dev \
"

#FIXME .config merge hack for now
do_compile_prepend_coral-dev () {
    ${S}/scripts/kconfig/merge_config.sh -m -O ${B} \
        ${B}/.config ${WORKDIR}/defconfig.coral-dev
}
