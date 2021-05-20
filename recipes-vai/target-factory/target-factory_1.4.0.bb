SUMMARY = "Target Factory"
DESCRIPTION = "A factory to manage DPU target description infos. Register targets and then you can get infos by name or fingerprint."

require recipes-vai/vitis-ai-library/vitisai.inc
SRC_URI = "git://gits@xcdl190260/aisw/target_factory.git;protocol=ssh;branch=dev"

SRCREV = "2a768f5741a22958cc1d38e0205cd868ecea86f5"

S = "${WORKDIR}/git"

DEPENDS = "unilog protobuf-native protobuf-c"

PACKAGECONFIG_append = " test"
PACKAGECONFIG[test] = "-DBUILD_TEST=ON,-DBUILD_TEST=OFF,,"

inherit cmake

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release"

# target-factory contains only one shared lib and will therefore become subject to renaming
# by debian.bbclass. Prevent renaming in order to keep the package name consistent 
AUTO_LIBNAME_PKGS = ""

FILES_SOLIBSDEV = ""
INSANE_SKIP_${PN} += "dev-so"
FILES_${PN} += "${libdir}/*.so"
