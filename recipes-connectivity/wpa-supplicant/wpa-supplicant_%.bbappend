FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGES =+ "${PN}-wlan0"
SYSTEMD_SERVICE:${PN}-wlan0 = "wpa_supplicant@wlan0.service"
SYSTEMD_AUTO_ENABLE:${PN}-wlan0 = "enable"

do_configure:append() {
    echo "ctrl_interface=/var/run/wpa_supplicant" > ${WORKDIR}/wpa_supplicant-wlan0.conf
    echo "network={" >> ${WORKDIR}/wpa_supplicant-wlan0.conf
    echo "    ssid=\"${WPA_SSID}\"" >> ${WORKDIR}/wpa_supplicant-wlan0.conf
    echo "    psk=\"${WPA_PSK}\"" >> ${WORKDIR}/wpa_supplicant-wlan0.conf
    echo "}" >> ${WORKDIR}/wpa_supplicant-wlan0.conf
}

do_install:append() {
	install -D -m0644 ${WORKDIR}/wpa_supplicant-wlan0.conf ${D}${sysconfdir}/wpa_supplicant-wlan0.conf
}