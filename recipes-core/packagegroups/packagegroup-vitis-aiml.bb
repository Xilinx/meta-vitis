DESCRIPTION = "Vitis AI/ML packages"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

VITIS_AI_ML_PACKAGES = " \
	fmt \
	glog \
	gsl \
	hdf5 \
	libeigen \
	nlohmann-json \
	python3-build \
	python3-pip \
	python3-pybind11 \
	python3-setuptools \
	python3-wheel \
	spdlog \
	zlib \
	"
VITIS_AI_ML_DEV_PACKAGES = " \
	fmt-dev \
	glog-dev \
	gsl-dev \
	h5pp-dev \
	hdf5-dev \
	libeigen-dev \
	nlohmann-json-dev \
	python3-numpy-dev \
	python3-pybind11-dev \
	python3-pybind11-json-dev \
	spdlog-dev \
	xsimd-dev \
	xtensor-dev \
	xtl-dev \
	zlib-dev \
	"

RDEPENDS:${PN} = "${VITIS_AI_ML_PACKAGES}"
RDEPENDS:${PN}-dev = "${VITIS_AI_ML_DEV_PACKAGES}"
