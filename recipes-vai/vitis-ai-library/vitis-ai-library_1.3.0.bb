SUMMARY = "Vitis AI LIBRARY"
DESCRIPTION = "Xilinx Vitis AI components - VITIS AI LIBRARY"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/Xilinx/Vitis-AI.git;protocol=https"
SRCREV = "e86b6efae11f8703ee647e4a99004dc980b84989"
S = "${WORKDIR}/git/tools/Vitis-AI-Library"

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
