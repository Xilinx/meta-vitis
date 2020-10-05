SUMMARY = "Target Factory"
DESCRIPTION = "A factory to manage DPU target description infos. Register targets and then you can get infos by name or fingerprint."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
PACKAGE_ARCH = "${SOC_FAMILY_ARCH}"

COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE_zynqmp = ".*"

TFPATH ?= "/proj/yocto/vitisai/target-factory_latest/target-factory.tar.gz"
SRC_URI = "file://${TFPATH}"

DEPENDS = "glog protobuf-c"
RDEPENDS_${PN} = "unilog-deploy"

do_install() {
    cp -r ${WORKDIR}/usr ${D}/

    # Due to the way things are copied, we need to
    # potentially correct permissions

    # We first have to clear all set-id perms (chmod won't clear these)
    chmod ug-s -R ${D}/*

    if [ -d ${D}/${LICENSE_FILES_DIRECTORY} ]; then
        # Now make sure the directory is set to 0755
        chmod 0755 ${D}/${LICENSE_FILES_DIRECTORY}
    fi
}

FILES_${PN} += " \
        /usr/* \
"
