FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = "file://wireless.network"

do_install:append() {
	install -D -m0644 ${WORKDIR}/wireless.network ${D}${systemd_unitdir}/network/85-wireless.network
}
