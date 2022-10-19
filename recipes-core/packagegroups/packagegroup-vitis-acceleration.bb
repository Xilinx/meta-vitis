DESCRIPTION = "Packages for Vitis compatible platforms"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "packagegroup-petalinux-vitis-acceleration"

PACKAGES += "${PN}-essential ${PN}-recommends"

OPENCV_RDEPENDS = " \
		opencv \
		libopencv-core \
		libopencv-highgui \
		libopencv-imgproc \
		libopencv-objdetect \
		libopencv-ml \
		libopencv-calib3d \
		libopencv-ccalib \
		"
OPENCV_RDEPENDS:petalinux = "packagegroup-petalinux-opencv"

RDEPENDS:${PN}-essential = " \
		xrt \
		zocl \
		opencl-headers \
		${OPENCV_RDEPENDS} \
		packagegroup-core-x11 \
		"
RRPLACES:${PN}-essential = "packagegroup-petalinux-vitis-acceleration-essential"

RRECOMMENDS:${PN}-recommends = " \
		gdb \
		valgrind \
		htop \
		iperf3 \
		meson \
		"
RRPLACES:${PN}-recommends = "packagegroup-petalinux-vitis-acceleration-recommends"

RDEPENDS:${PN}-essential:append:versal-ai-core = "ai-engine-driver"
