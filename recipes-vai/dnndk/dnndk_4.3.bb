SUMMARY = "Vitis AI DNNDK Runtime"
DESCRIPTION = "Xilinx Vitis AI DNNDK Runtime User Space Libraries and headers"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/Xilinx/Vitis-AI.git;protocol=https"
SRCREV = "e86b6efae11f8703ee647e4a99004dc980b84989"

S = "${WORKDIR}/git/tools/Vitis-AI-Runtime/DNNDK"

inherit autotools-brokensep
inherit distutils3-base

DEPENDS = "xrt python3-setuptools-native"

DISTUTILS_INSTALL_ARGS ?= "--root=${D} \
	--prefix=${prefix} \
	--install-lib=${PYTHON_SITEPACKAGES_DIR} \
	--install-data=${datadir}"

PACKAGE_ARCH = "${SOC_FAMILY_ARCH}"

COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE_zynqmp = ".*"

do_compile_append() {

	cd ${S}/n2cube/python
	${PYTHON} setup.py build
}

do_install_append() {

	cd ${S}/n2cube/python
	${PYTHON} setup.py install ${DISTUTILS_INSTALL_ARGS}
}

FILES_${PN} += " \
	${libdir}/echarts.js \
	${libdir}/libdsight.pyc \
"
