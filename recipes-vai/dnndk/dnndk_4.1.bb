SUMMARY = "Vitis AI DNNDK Runtime"
DESCRIPTION = "Xilinx Vitis AI DNNDK Runtime User Space Libraries and headers"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://gits@xcdl190260/SDK/vitis-ai-dnndk.git;protocol=ssh;branch=2020.1"
SRCREV = "55a40be82237afe6db13f1ce46f203a9c3eb1448"

S = "${WORKDIR}/git"

inherit autotools-brokensep

PACKAGE_ARCH = "${SOC_FAMILY_ARCH}"

COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE_zynqmp = ".*"

DEPENDS = "xrt"

FILES_${PN} += " \
	${libdir}/echarts.js \
	${libdir}/libdsight.pyc \
"
