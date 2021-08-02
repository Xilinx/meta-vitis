SUMMARY = "Vitis AI RunTime"
DESCRIPTION = "Runner is an application level runtime interface for DPU IPs based on XRT. It use XIR subgraph as input, and run it on different targets. There are also emulators implemented with same interface to make debuging eaiser."

require recipes-vai/vitis-ai-library/vitisai.inc
SRC_URI = "git://gitenterprise.xilinx.com/aisw/vart.git;protocol=https;branch=dev \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRCREV = "381d15b99239a93251b9cdbef216995a61009e34"

S = "${WORKDIR}/git"

DEPENDS = "json-c xrt xir target-factory"

PACKAGECONFIG:append = " python test"
PACKAGECONFIG[python] = "-DBUILD_PYTHON=ON -DPYTHON_INSTALL_DIR=${PYTHON_DIR},-DBUILD_PYTHON=OFF,,python3-core"
PACKAGECONFIG[test] = "-DBUILD_TEST=ON,-DBUILD_TEST=OFF,opencv,"

inherit cmake python3-dir

EXTRA_OECMAKE += "-DENABLE_CPU_RUNNER=OFF -DENABLE_SIM_RUNNER=OFF -DENABLE_DPU_RUNNER=ON -DCMAKE_BUILD_TYPE=Release -DCMAKE_SYSROOT=${STAGING_DIR_HOST}"

# Vart uses dl_open, so package the .so files in the runtime package
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} += "dev-so"
FILES:${PN} += " \
	${libdir}/*.so \
	${PYTHON_SITEPACKAGES_DIR} \
"

SYSROOT_DIRS += "${bindir}"
