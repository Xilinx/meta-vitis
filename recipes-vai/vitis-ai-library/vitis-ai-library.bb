SUMMARY = "Vitis AI LIBRARY"
DESCRIPTION = "Xilinx Vitis AI components - VITIS AI LIBRARY"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://gits@xcdl190260/aisw/vitis-ai-library.git;protocol=ssh;branch=dev"
SRCREV = "6fecaa50a473212e6820bde43edc5ce6622e8de1"
S = "${WORKDIR}/git"

DEPENDS = "protobuf-native vart opencv googletest"
RDEPENDS_${PN} = "python3-core"

inherit cmake

EXTRA_OECMAKE += "-DENABLE_OVERVIEW=ON"

FILES_${PN} += " \
	${datadir} \
	${prefix}/settings.sh \
"
