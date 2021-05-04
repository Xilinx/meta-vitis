SUMMARY = "Vitis AI LIBRARY"
DESCRIPTION = "Xilinx Vitis AI components - VITIS AI LIBRARY"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

require recipes-vai/vitis-ai-library/vitisai.inc

SRC_URI += " \
	file://0001-To-be-compatible-with-opencv4.4-and-gcc10.2.patch \
"
S = "${WORKDIR}/git/tools/Vitis-AI-Library"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS = "protobuf-native vart opencv googletest libeigen libeigen-native"
RDEPENDS_${PN} = "python3-core"

inherit cmake

EXTRA_OECMAKE += "-DENABLE_OVERVIEW=OFF -DCMAKE_BUILD_TYPE=Release -DCMAKE_SYSROOT=${STAGING_DIR_HOST}"

do_install_append() {

	rm ${D}/${libdir}/libvart_op_imp_fix2float.so
	rm ${D}/${libdir}/libvart_op_imp_fix.so
	rm ${D}/${libdir}/libvart_op_imp_softmax.so
}

FILES_${PN} += " \
	${datadir} \
	${prefix}/settings.sh \
"
