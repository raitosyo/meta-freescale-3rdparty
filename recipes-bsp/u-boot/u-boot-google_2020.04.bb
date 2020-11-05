# Copyright (C) 2012-2019 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

inherit fsl-u-boot-localversion
require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

DESCRIPTION = "Coral U-Boot supporting the Google Coral Dev board/SOM"

DEPENDS += "bison-native bc-native dtc-native lzop-native"

SRC_URI = "git://github.com/raitosyo/u-boot-fslc;protocol=https;branch=${SRCBRANCH}"

SRCBRANCH = "WIP_google-2020.04+fslc"
SRCREV = "${AUTOREV}"

PV = "v2020.04+git${SRCPV}"

LOCALVERSION ?= "-${SRCBRANCH}"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

PROVIDES += "u-boot"

# FIXME: Allow linking of 'tools' binaries with native libraries
#        used for generating the boot logo and other tools used
#        during the build process.
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CPPFLAGS}" \
                 HOSTLDFLAGS="${BUILD_LDFLAGS}" \
                 HOSTSTRIP=true'

BOOT_TOOLS = "imx-boot-tools"

do_deploy_append_mx8m() {
    install -d ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0777 ${B}/${config}/arch/arm/dts/${UBOOT_DTB_NAME}  ${DEPLOYDIR}/${BOOT_TOOLS}
    #install -m 0777 ${B}/${config}/tools/mkimage  ${DEPLOYDIR}/${BOOT_TOOLS}/mkimage_uboot
    install -m 0777 ${B}/${config}/u-boot-nodtb.bin  ${DEPLOYDIR}/${BOOT_TOOLS}/u-boot-nodtb.bin-${MACHINE}-${UBOOT_CONFIG}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(coral-dev)"
