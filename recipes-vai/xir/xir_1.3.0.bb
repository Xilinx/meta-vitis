SUMMARY = "Vitis AI XIR"
DESCRIPTION = "Xilinx Intermediate Representation for deep learning algorithm. Define a graph based represention, provide APIs to serialize or deserialize a model and APIs for basic graph operations."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

require recipes-vai/vitis-ai-library/vitisai.inc

SRC_URI += " \
	file://0001-Solve-problem-of-compatibility-among-different-versi.patch \
"
S = "${WORKDIR}/git/tools/Vitis-AI-Runtime/VART/xir"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS = "protobuf-native protobuf-c boost unilog"

PACKAGECONFIG_append = " test python"
PACKAGECONFIG[test] = "-DBUILD_TEST=ON,-DBUILD_TEST=OFF,,"
PACKAGECONFIG[python] = "-DBUILD_PYTHON=ON,-DBUILD_PYTHON=OFF,python3-pybind11,"

inherit cmake

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS:BOOL=TRUE -DCMAKE_BUILD_TYPE=Release -DBUILD_CONTRIB=OFF -DBUILD_DOC=OFF -DINSTALL_USER=ON "

# need to include python3.7/site-packages/ folder if PACKAGECONFIG includes python
FILES_${PN} += "${libdir}/*"
