SUMMARY = "Target Factory"
DESCRIPTION = "A factory to manage DPU target description infos. Register targets and then you can get infos by name or fingerprint."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://gits@xcdl190260/aisw/target_factory.git;protocol=ssh;branch=dev"
SRCREV = "660ee92cbaaa631bffd5780dde5d95b23996241c"
S = "${WORKDIR}/git"

PACKAGE_ARCH = "${SOC_FAMILY_ARCH}"

COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE_zynqmp = ".*"

DEPENDS = "unilog protobuf-native protobuf-c"

inherit cmake

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release"
