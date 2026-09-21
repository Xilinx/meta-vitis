# xsimd, xtensor and xtl are supplied by meta-ros. They belong to the
# AI/ML stack, but requiring all of meta-ros to obtain three
# header-only packages would be a steep price for any consumer of this
# layer that does not otherwise want ROS.
VITIS_AI_ML_DEV_PACKAGES += " \
	xsimd-dev \
	xtensor-dev \
	xtl-dev \
	"
