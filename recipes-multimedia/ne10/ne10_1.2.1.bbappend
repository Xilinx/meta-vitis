# Already integrated upstream in 1f059a764d0e1bc2481c0055c0e71538470baa83
SRC_URI:remove = "file://0001-CMakeLists.txt-Remove-mthumb-interwork.patch"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://0001-cmake-modification-arm-to-aarch.patch"
SRCREV = "1f059a764d0e1bc2481c0055c0e71538470baa83"

NE10_TARGET_ARCH:armv8 = "armv8"
