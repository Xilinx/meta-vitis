SUMMARY = "Vitis AI LIBRARY"
DESCRIPTION = "Xilinx Vitis AI components - VITIS AI LIBRARY"

require recipes-vai/vitis-ai-library/vitisai.inc

S = "${WORKDIR}/git/src/vai_library"

DEPENDS = "protobuf-native vart opencv googletest libeigen libeigen-native pkgconfig-native"

PACKAGECONFIG[test] = ",,,"
PACKAGECONFIG[python] = "-DBUILD_PYTHON=ON -DPYTHON_INSTALL_DIR=${PYTHON_DIR},-DBUILD_PYTHON=OFF,, python3-core python3-crypt python3-json python3-numpy python3-protobuf graphviz python3-graphviz bash"

inherit cmake python3-dir

EXTRA_OECMAKE += " -DCMAKE_BUILD_TYPE=Release -DCMAKE_SYSROOT=${STAGING_DIR_HOST} -DBUILD_SHARED_LIBS=ON -DARG_ENABLE_IF=TRUE"

FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} += "dev-so"

FILES:${PN} += " \
	${datadir} \
	${prefix}/settings.sh \
	${PYTHON_SITEPACKAGES_DIR} \
	${libdir}/*.so \
"
