DESCRIPTION = "PetaLinux Vitis AI packages"

# Package contains references to renamed binaries, so is arch specific
PACKAGE_ARCH = "${SOC_FAMILY_ARCH}"

inherit packagegroup

COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE:zynqmp = ".*"
COMPATIBLE_MACHINE:versal = ".*"

RDEPENDS:${PN} = "\
    glog \
    googletest \
    json-c \
    protobuf \
    python3-pip \
    opencv \
    python3-pybind11 \
    vitis-ai-library \
    xir \
    target-factory \
    vart \
    unilog \
    "

RDEPENDS:${PN}-dev += "\
    protobuf-c \
    libeigen-dev \
    python3-marshmallow \
    python3-tqdm \
    python3-h5py \
    "
