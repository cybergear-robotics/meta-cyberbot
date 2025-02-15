SUMMARY = "Provides a RFC2217 telnet port for a serial connection to a ESP"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a04e0b7002b74fb17ab1ad61a72aabed"

SRC_URI = " \
    git://github.com/cybergear-robotics/esp_rfc2217_server;branch=master;protocol=https \
    file://esp-rfc2217-server.service \
"
SRCREV = "8e9b831329f7b4115d524ef9316d94a8c7ba6edb"

FILES:${PN} += " \
    ${systemd_system_unitdir}/esp-rfc2217-server.service \
" 

S = "${WORKDIR}/git"

inherit setuptools3 systemd

SYSTEMD_SERVICE:${PN} = "esp-rfc2217-server.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

RDEPENDS:${PN} += " \
    python3-pyserial \
    rpi-gpio \
"


do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/esp-rfc2217-server.service ${D}${systemd_system_unitdir}/esp-rfc2217-server.service
}