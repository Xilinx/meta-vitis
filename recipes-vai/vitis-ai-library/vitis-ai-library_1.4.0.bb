SUMMARY = "Vitis AI LIBRARY"
DESCRIPTION = "Xilinx Vitis AI components - VITIS AI LIBRARY"

require recipes-vai/vitis-ai-library/vitisai.inc
SRC_URI = "git://gits@xcdl190260/aisw/Vitis-AI-Library.git;protocol=ssh;branch=dev"

SRCREV = "a63f1d5a89d2b0751e4fe52751997b27cf50ade6"

S = "${WORKDIR}/git"

DEPENDS = "protobuf-native vart opencv googletest libeigen libeigen-native"
RDEPENDS_${PN} = "python3-core"

PACKAGECONFIG_append = " python" 
PACKAGECONFIG[python] = "-DBUILD_PYTHON=ON,-DBUILD_PYTHON=OFF,,python3-core bash"

inherit cmake python3-dir

EXTRA_OECMAKE += "-DENABLE_OVERVIEW=OFF -DCMAKE_BUILD_TYPE=Release -DCMAKE_SYSROOT=${STAGING_DIR_HOST} -DBUILD_SHARED_LIBS=ON"

FILES_SOLIBSDEV = ""
INSANE_SKIP_${PN} += "dev-so"

FILES_${PN} += " \
	${datadir} \
	${libdir}/*.so \
	${prefix}/settings.sh \
	${PYTHON_SITEPACKAGES_DIR} \
"
