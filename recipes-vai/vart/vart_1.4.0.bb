SUMMARY = "Vitis AI RunTime"
DESCRIPTION = "Runner is an application level runtime interface for DPU IPs based on XRT. It use XIR subgraph as input, and run it on different targets. There are also emulators implemented with same interface to make debuging eaiser."

require recipes-vai/vitis-ai-library/vitisai.inc
SRC_URI = "git://gits@xcdl190260/aisw/vart.git;protocol=ssh;branch=dev \
	file://0001-Vart-don-t-find-python-executable.patch \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRCREV = "9c686a3c7c9d2ef762aa41531a3e5a9549423c24"

S = "${WORKDIR}/git"

DEPENDS = "json-c xrt xir target-factory"

PACKAGECONFIG_append = " python test"
PACKAGECONFIG[python] = "-DBUILD_PYTHON=ON -DPYTHON_INSTALL_DIR=${PYTHON_DIR},-DBUILD_PYTHON=OFF,,python3-core"
PACKAGECONFIG[test] = "-DBUILD_TEST=ON,-DBUILD_TEST=OFF,opencv,"

inherit cmake python3-dir

EXTRA_OECMAKE += "-DENABLE_CPU_RUNNER=OFF -DENABLE_SIM_RUNNER=OFF -DENABLE_DPU_RUNNER=ON -DCMAKE_BUILD_TYPE=Release -DCMAKE_SYSROOT=${STAGING_DIR_HOST}"

# Vart uses dl_open, so package the .so files in the runtime package
FILES_SOLIBSDEV = ""
INSANE_SKIP_${PN} += "dev-so"
FILES_${PN} += " \
	${libdir}/*.so \
	${PYTHON_SITEPACKAGES_DIR} \
"

SYSROOT_DIRS += "${bindir}"
