SUMMARY = "Vitis AI LIBRARY"
DESCRIPTION = "Xilinx Vitis AI components - VITIS AI LIBRARY"

require recipes-vai/vitis-ai-library/vitisai.inc

SRC_URI += "file://0001-Add-missing-include-array.patch;striplevel=3"

S = "${WORKDIR}/git/src/Vitis-AI-Library"

DEPENDS = "protobuf-native vart opencv googletest libeigen libeigen-native"

PACKAGECONFIG[test] = ",,,"
PACKAGECONFIG[python] = "-DBUILD_PYTHON=ON -DPYTHON_INSTALL_DIR=${PYTHON_DIR},-DBUILD_PYTHON=OFF,, python3-core python3-crypt python3-json python3-numpy python3-protobuf graphviz python3-graphviz bash"

inherit cmake python3-dir pkgconfig

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release -DCMAKE_SYSROOT=${STAGING_DIR_HOST} -DBUILD_SHARED_LIBS=ON"

# Workaround for: error: 'unsigned char* MD5(const unsigned char*, size_t, unsigned char*)' is deprecated: Since OpenSSL 3.0
CXXFLAGS += "-Wno-deprecated-declarations"

# Workaround for: -Wall causing an issue with an unused-result
CXXFLAGS += "-Wno-unused-result"

# Workaround for: -Wall causing an issue with possibly uninitialized values
CXXFLAGS += "-Wno-maybe-uninitialized"

FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} += "dev-so"

FILES:${PN} += " \
	${datadir} \
	${prefix}/settings.sh \
	${PYTHON_SITEPACKAGES_DIR} \
	${libdir}/*.so \
"
