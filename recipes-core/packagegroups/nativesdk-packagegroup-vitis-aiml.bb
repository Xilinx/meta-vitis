SUMMARY = "Native-SDK packagegroup containing the host-side AMD Vitis \
AI/ML tooling shipped in the SDK installer."
DESCRIPTION = "Vitis AI/ML packages for SDK"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup
inherit_defer nativesdk

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

VITIS_AI_ML_NATIVESDK_PACKAGES = " \
	nativesdk-python3-build \
	nativesdk-python3-numpy \
	nativesdk-python3-pip \
	nativesdk-python3-pybind11 \
	nativesdk-python3-setuptools \
	nativesdk-python3-wheel \
	"

RDEPENDS:${PN} = "${VITIS_AI_ML_NATIVESDK_PACKAGES}"
