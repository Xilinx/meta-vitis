DESCRIPTION = "Vitis Video Analytics SDK (VVAS) packages"

inherit packagegroup

VVAS_PACKAGES = " \
	vvas-accel-libs \
	vvas-gst \
	vvas-utils \
	"

RDEPENDS:${PN} = "${VVAS_PACKAGES}"
