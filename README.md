# meta-vitis

This layer provides support for Vitis libraries, Apps, VAI(Vitis AI), VVAS(Vitis Video Analytics SDK),
packagegroups and image recipes.

## Maintainers, Patches/Submissions, Community

Please open pull requests for any changes.

For more details follow the Yocto Project community patch submission guidelines,
as described in:

https://docs.yoctoproject.org/dev/contributor-guide/submit-changes.html#

When creating patches, please use below format.

**Syntax:**
`git format-patch -s --subject "meta-vitis][<release-version>][PATCH" -1`

**Example:**
`git format-patch -s --subject "meta-vitis][rel-v2024.2][PATCH" -1`

**Maintainers:**

	Mark Hatle <mark.hatle@amd.com>
	Sandeep Gundlupet Raju <sandeep.gundlupet-raju@amd.com>
	John Toomey <john.toomey@amd.com>
	Trevor Woerner <trevor.woerner@amd.com>

## Dependencies

This layer depends on:

	URI: https://git.yoctoproject.org/poky
	layers: meta, meta-poky
	branch: scarthgap

	URI: https://git.openembedded.org/meta-openembedded
	layers: meta-oe
	branch: scarthgap

	URI:
        https://git.yoctoproject.org/meta-xilinx (official version)
        https://github.com/Xilinx/meta-xilinx (development and AMD release)
	layers: meta-xilinx-core, meta-xilinx-microblaze, meta-xilinx-bsp,
            meta-xilinx-standalone, meta-xilinx-vendor.
	branch: scarthgap or AMD release version (e.g. rel-v2024.2)

	URI: https://git.yoctoproject.org/meta-arm
	layers: meta-arm, meta-arm-toolchain
	branch: scarthgap
