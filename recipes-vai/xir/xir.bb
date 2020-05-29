SUMMARY = "Vitis AI XIR"
DESCRIPTION = "Xilinx Intermediate Representation for deep learning algorithm. Define a graph based represention, provide APIs to serialize or deserialize a model and APIs for basic graph operations."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://gits@xcdl190260/aisw/xir.git;protocol=ssh;branch=dev"
SRCREV = "7e4cd788a8790faa720476453666b18c60f0dac8"
S = "${WORKDIR}/git"

PACKAGE_ARCH = "${SOC_FAMILY_ARCH}"

COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE_zynqmp = ".*"

DEPENDS = "protobuf-native protobuf-c boost unilog python3-pybind11"

inherit cmake

EXTRA_OECMAKE += "-DBUILD_PYTHON=ON" 

FILES_${PN} += "${libdir}/*"
