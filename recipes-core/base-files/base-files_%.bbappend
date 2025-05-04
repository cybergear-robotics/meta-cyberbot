FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = "file://ros2.sh"

do_install:append() {
	install -d ${D}${sysconfdir}/profile.d/
	install -D -m 0644 ${WORKDIR}/ros2.sh ${D}${sysconfdir}/profile.d/ros2.sh
}
