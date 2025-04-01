DESCRIPTION = "CyberBot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += " \
    git://github.com/cybergear-robotics/ros2-cyberbot.git;protocol=https;branch=master \
    file://cyberbot.service \
    file://cyberbot-init.sh \
"
SRCREV = "a9984ee7fadf5d9b9600b608dbac551d92654d81"


inherit ros_distro_jazzy ros_ament_cmake systemd 

SYSTEMD_SERVICE:${PN} = "cyberbot.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

INSANE_SKIP:${PN}-dev += "dev-elf"
INSANE_SKIP:${PN} += "dev-deps"
RDEPENDS:remove:${PN}-dev = "${PN}"

DEPENDS = "ament-cmake-native rosidl-default-generators-native rosidl-default-runtime-native"

RDEPENDS:${PN} = " \
    mcu-msgs \
    micro-ros-agent \
    realsense2-camera \
    sllidar-ros2 \
"

S = "${WORKDIR}/git/cyberbot_bringup"


do_install:append() {
    install -d ${D}${bindir}
    install -m 0644 ${WORKDIR}/cyberbot-init.sh ${D}${bindir}/cyberbot-init
    chmod +x ${D}${bindir}/cyberbot-init
    
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/cyberbot.service ${D}${systemd_system_unitdir}/cyberbot.service
}

FILES:${PN} += " \
    ${systemd_system_unitdir}/cyberbot.service \
    ${bindir}/cyberbot-init \
" 

