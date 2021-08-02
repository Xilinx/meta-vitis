SUMMARY = "Vitis AI UNILOG"
DESCRIPTION = "Xilinx Vitis AI components - a wrapper for glog. Define unified log formats for vitis ai tools."

require recipes-vai/vitis-ai-library/vitisai.inc

SRC_URI = "git://gitenterprise.xilinx.com/aisw/unilog.git;protocol=https;branch=dev \
	file://0001-fix-python-path-for-petalinux.patch \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRCREV = "14965744a391cce3cb07e0ec128d5022450f1e1a"
S = "${WORKDIR}/git"

DEPENDS = "glog boost"

PACKAGECONFIG:append = " test"
PACKAGECONFIG[test] = "-DBUILD_TEST=ON,-DBUILD_TEST=OFF,,"

inherit cmake

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release"

# unilog contains only one shared lib and will therefore become subject to renaming
# by debian.bbclass. Prevent renaming in order to keep the package name consistent 
AUTO_LIBNAME_PKGS = ""

FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} += "dev-so"
FILES:${PN} += "${libdir}/*.so"
