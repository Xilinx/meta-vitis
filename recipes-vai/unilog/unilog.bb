SUMMARY = "Vitis AI UNILOG"
DESCRIPTION = "Xilinx Vitis AI components - a wrapper for glog. Define unified log formats for vitis ai tools."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://gits@xcdl190260/aisw/unilog.git;protocol=ssh;branch=dev"
SRCREV = "037d510126da34b03500527c326bd9459399a21d"
S = "${WORKDIR}/git"

DEPENDS = "glog"

inherit cmake

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release"
