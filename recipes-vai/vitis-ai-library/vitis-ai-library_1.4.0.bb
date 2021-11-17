SUMMARY = "Vitis AI LIBRARY"
DESCRIPTION = "Xilinx Vitis AI components - VITIS AI LIBRARY"

require recipes-vai/vitis-ai-library/vitisai.inc

SRC_URI += "file://vai-reboot.patch file://vai-limits.patch file://vai-Werror.patch"

S = "${WORKDIR}/git/tools/Vitis-AI-Library"

DEPENDS = "protobuf-native vart opencv googletest libeigen libeigen-native"
RDEPENDS:${PN} = "python3-core"

PACKAGECONFIG:append = " python" 
PACKAGECONFIG[python] = "-DBUILD_PYTHON=ON -DPYTHON_INSTALL_DIR=${PYTHON_DIR},-DBUILD_PYTHON=OFF,,python3-core bash"

inherit cmake python3-dir

EXTRA_OECMAKE += "-DENABLE_OVERVIEW=OFF -DCMAKE_BUILD_TYPE=Release -DCMAKE_SYSROOT=${STAGING_DIR_HOST} -DBUILD_SHARED_LIBS=ON"

RDEPENDS:${PN} = "${PN}-libs"

PACKAGES =+ "${PN}-libs"

FILES:${PN}-libs = "\
	${libdir}/libvart_op_imp*.so \
	${libdir}/lib*.so.1 \
	${libdir}/lib*.so.1.4.0 \
"

FILES:${PN} += " \
	${datadir} \
	${prefix}/settings.sh \
	${PYTHON_SITEPACKAGES_DIR} \
"
