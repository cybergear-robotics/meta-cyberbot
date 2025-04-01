SUMMARY = "OpenOCD for ESP32 debugging"
HOMEPAGE = "https://github.com/espressif/openocd-esp32"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=599d2d1ee7fc84c0467b3d19801db870"

SRC_URI = " \
    gitsm://github.com/espressif/openocd-esp32;protocol=https;branch=master \
    file://openocd.service \
"
SRCREV = "0937211215e6feaff078df1872f68f2308d0abac"

S = "${WORKDIR}/git"

DEPENDS = "libusb1 libtool automake autoconf pkgconfig texinfo"

inherit pkgconfig autotools-brokensep gettext

EXTRA_OECONF = "--enable-sysfsgpio --enable-bcm2835gpio --disable-doxygen-html --disable-werror"

BBCLASSEXTEND += "native nativesdk"


do_configure() {
    ./bootstrap nosubmodule
    install -m 0755 ${STAGING_DATADIR_NATIVE}/gnu-config/config.guess ${S}/jimtcl/autosetup
    install -m 0755 ${STAGING_DATADIR_NATIVE}/gnu-config/config.sub ${S}/jimtcl/autosetup
    oe_runconf ${EXTRA_OECONF}
}

do_install() {
    oe_runmake DESTDIR=${D} install
    if [ -e "${D}${infodir}" ]; then
      rm -Rf ${D}${infodir}
    fi
    if [ -e "${D}${mandir}" ]; then
      rm -Rf ${D}${mandir}
    fi
    if [ -e "${D}${bindir}/.debug" ]; then
      rm -Rf ${D}${bindir}/.debug
    fi

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/openocd.service ${D}${systemd_system_unitdir}/openocd.service
}

FILES:${PN} = " \
  ${datadir}/openocd/* \
  ${bindir}/openocd \
  ${systemd_system_unitdir}/openocd.service \
"

# Can't be built with ccache
CCACHE_DISABLE = "1"

