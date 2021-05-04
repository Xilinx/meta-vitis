SUMMARY = "Vitis AI RunTime"
DESCRIPTION = "Runner is an application level runtime interface for DPU IPs based on XRT. It use XIR subgraph as input, and run it on different targets. There are also emulators implemented with same interface to make debuging eaiser."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

require recipes-vai/vitis-ai-library/vitisai.inc

SRC_URI += " \
	file://0001-Solve-problem-of-compatibility-among-different-versi.patch \
	file://0002-Compatible-with-opencv4.4.patch \
"
S = "${WORKDIR}/git/tools/Vitis-AI-Runtime/VART/vart"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS = "json-c xrt xir target-factory"

PACKAGECONFIG_append = " python test"
PACKAGECONFIG[python] = "-DBUILD_PYTHON=ON,-DBUILD_PYTHON=OFF,,python3-core"
PACKAGECONFIG[test] = "-DBUILD_TEST=ON,-DBUILD_TEST=OFF,opencv,"

inherit cmake

EXTRA_OECMAKE += "-DENABLE_CPU_RUNNER=OFF -DENABLE_SIM_RUNNER=OFF -DENABLE_DPU_RUNNER=ON -DCMAKE_BUILD_TYPE=Release"

# Vart uses dl_open, so package the .so files in the runtime package
FILES_SOLIBSDEV = ""
INSANE_SKIP_${PN} += "dev-so"

# need to include python3.7/site-packages/runner.so if PACKAGECONFIG includes python
FILES_${PN} += "${libdir}/*"

# need to include recipe-sysroot-native/usr/bin/dpu_model_inspect
SYSROOT_DIRS += "${bindir}"
