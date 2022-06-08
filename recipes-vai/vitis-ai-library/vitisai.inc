LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

BRANCH = "2.5"
SRC_URI = "git://github.com/Xilinx/Vitis-AI.git;protocol=https;branch=${BRANCH}"

SRCREV = "fb0a303e9464b52ba7b0617071335fd2331c9697"

PACKAGECONFIG:append = " python"
PACKAGECONFIG:append = " test"
