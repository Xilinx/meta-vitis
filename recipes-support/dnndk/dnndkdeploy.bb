SUMMARY = "Vitis AI DNNDK Runtime"
DESCRIPTION = "Xilinx Vitis AI DNNDK Runtime User Space Libraries and headers"

LICENSE = "CLOSED"

DNNDKPATH="/proj/yocto/dnndk/${SOC_FAMILY}_latest"
SRC_URI = "file://${DNNDKPATH}"

RDEPENDS_${PN} = "xrt"

do_install() {
    cp -r ${DNNDKPATH}/usr ${D}/
}

FILES_${PN} += " \
	/usr/* \
"
