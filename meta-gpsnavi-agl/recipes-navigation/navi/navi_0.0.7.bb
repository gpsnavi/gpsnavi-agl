LICENSE="GPLv2 | COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE;md5=3595e9c703a847d990664d2b396a9df0 \
                  file://COPYING;md5=947b2d60ca3872e172034438e9801200"

DEPENDS =        "glib-2.0 freetype sqlite3 wayland zlib expat openssl virtual/libgles2"
RDEPENDS_${PN} = "glib-2.0 freetype sqlite3 wayland zlib expat openssl libegl libwayland-egl"

SRCREV="v0.0.7"
SRC_URI="git://github.com/gpsnavi/gpsnavi.git"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_libtool_fix () {
	if [ "${TARGET_SYS}" = "arm-poky-linux-gnueabi" ]; then
		BUILDDIR="${S}/../build"
		LIBTOOL="${BUILDDIR}/arm-poky-linux-gnueabi-libtool"
		sed -i 's/predep_objects=".*"/predep_objects=""/' $LIBTOOL
		sed -i 's/postdep_objects=".*"/postdep_objects=""/' $LIBTOOL
	fi
}

addtask libtool_fix before do_compile after do_configure
