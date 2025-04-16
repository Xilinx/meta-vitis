DESCRIPTION = "h5pp is a high-level, header-only, C++17 interface for the HDF5 C library."
HOMEPAGE = "https://github.com/DavidAce/h5pp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=08b672edb94ecca6dddee852b4d53cd2"

SRC_URI = "git://github.com/DavidAce/h5pp;protocol=https;branch=master"

PV = "1.11.2+git"
SRCREV = "81bc69633e91245231bc905fe47176a090854683"

S = "${WORKDIR}/git"

DEPENDS = "zlib hdf5 spdlog fmt libeigen"

inherit cmake

# The h5pp source comes with a "quickstart" directory which includes a set of
# examples for the user to try. If I'm reading this correctly, bitbake looks
# in this directory, finds a subdirectory that ends in ".py" and gets confused
# that this is a directory and not a file:
#
# .../poky/meta/classes-global/insane.bbclass', lineno: 1377, function: do_qa_patch
# Exception: IsADirectoryError: [Errno 21] Is a directory: '.../build/tmp/work/cortexa72-cortexa53-amd-linux/h5pp/1.0+git/git/quickstart/git-clone-install-with-conanfile.py'
do_source_cleanup() {
       mv ${S}/quickstart/git-clone-install-with-conanfile.py ${S}/quickstart/git-clone-install-with-conanfile
}
addtask do_source_cleanup after do_unpack before do_patch
