DESCRIPTION = "Vitis AI packages"

inherit packagegroup

PROVIDES = "packagegroup-petalinux-vitisai"

# Since dnndk is SOC_FAMILY specific, this package must be also
PACKAGE_ARCH = "${SOC_FAMILY_ARCH}"

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
RREPLACES:${PN} = "packagegroup-petalinux-vitisai"

RDEPENDS:${PN}-dev += "\
    protobuf-c \
    libeigen-dev \
    python3-marshmallow \
    python3-tqdm \
    python3-h5py \
    "
RREPLACES:${PN}-dev = "packagegroup-petalinux-vitisai-dev"
