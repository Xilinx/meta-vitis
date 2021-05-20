SUMMARY = "Vitis AI XIR"
DESCRIPTION = "Xilinx Intermediate Representation for deep learning algorithm. Define a graph based represention, provide APIs to serialize or deserialize a model and APIs for basic graph operations."

require recipes-vai/vitis-ai-library/vitisai.inc
SRC_URI = "git://gits@xcdl190260/aisw/xir.git;protocol=ssh;branch=dev"

SRCREV = "1a9246337177f50f0c51d9d14d8e854c89088dca"

S = "${WORKDIR}/git"

DEPENDS = "protobuf-native protobuf-c boost unilog"

PACKAGECONFIG_append = " test python"
PACKAGECONFIG[test] = "-DBUILD_TEST=ON,-DBUILD_TEST=OFF,,"
PACKAGECONFIG[python] = "-DBUILD_PYTHON=ON -DPYTHON_INSTALL_DIR=${PYTHON_DIR},-DBUILD_PYTHON=OFF,python3-pybind11,"

inherit cmake python3-dir

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS:BOOL=TRUE -DCMAKE_BUILD_TYPE=Release -DBUILD_CONTRIB=OFF -DBUILD_DOC=OFF -DINSTALL_USER=OFF -DCMAKE_SYSROOT=${STAGING_DIR_HOST}"

FILES_SOLIBSDEV = ""
INSANE_SKIP_${PN} += "dev-so"
FILES_${PN} += " \
	${libdir}/*.so \
	${PYTHON_SITEPACKAGES_DIR} \
"
