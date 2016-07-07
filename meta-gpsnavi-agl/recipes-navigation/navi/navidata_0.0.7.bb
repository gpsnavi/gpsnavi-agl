DESCRIPTION = "Navigation Open Source Project Navi Data."
HOMEPAGE = "http://agl.wismobi.com/"
LICENSE="GPLv2 | COMMERCIAL"

SRC_URI = "http://agl.wismobi.com/data/japan_TR9/navi_data.tar.gz \
	   "
LIC_FILES_CHKSUM="file:///${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI[md5sum] = "4fd44b0633d44d41c07227d086cd299c"
SRC_URI[sha256sum] = "ce39a36741baccd6b40277acb8c81ebc181997c75483dffb46ccd22f7877295a"

PR = "r0"

inherit allarch

DEPENDS = "navi"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} =  "/opt/AGL/navi/*/*/*/* /opt/AGL/navi/*/*/* /opt/AGL/navi/*/*"

do_install () {
    mkdir -p ${D}/opt/AGL/navi
    cp -R ${WORKDIR}/navi_data ${D}/opt/AGL/navi
}

