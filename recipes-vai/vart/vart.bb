SUMMARY = "Vitis AI RunTime"
DESCRIPTION = "Runner is an application level runtime interface for DPU IPs based on XRT. It use XIR subgraph as input, and run it on different targets. There are also emulators implemented with same interface to make debuging eaiser."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://gits@xcdl190260/aisw/vart.git;protocol=ssh;branch=dev"
SRCREV = "081c60cb56ce6d3bc39f620fe569c5d61d73b285"
S = "${WORKDIR}/git"

DEPENDS = "json-c xrt xir target-factory"

inherit cmake

EXTRA_OECMAKE += "-DENABLE_CPU_RUNNER=OFF -DENABLE_SIM_RUNNER=OFF -DENABLE_DPU_RUNNER=ON -DBUILD_PYTHON=ON"

FILES_${PN} += "${libdir}/*"

SYSROOT_DIRS += "${bindir}"
