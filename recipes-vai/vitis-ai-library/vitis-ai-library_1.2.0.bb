SUMMARY = "Vitis AI LIBRARY"
DESCRIPTION = "Xilinx Vitis AI components - VITIS AI LIBRARY"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://gits@xcdl190260/aisw/vitis-ai-library.git;protocol=ssh;nobranch=1"
SRCREV = "4839aa08bb4b3948def000c2b683bc7836d41001"
S = "${WORKDIR}/git"

DEPENDS = "protobuf-native vart opencv googletest"
RDEPENDS_${PN} = "python3-core"

inherit cmake

EXTRA_OECMAKE += "-DENABLE_OVERVIEW=ON -DCMAKE_BUILD_TYPE=Release -DBUILD_TEST=ON -DBUILD_SHARED_LIBS=ON"

FILES_${PN} += " \
	${datadir} \
	${prefix}/settings.sh \
"
