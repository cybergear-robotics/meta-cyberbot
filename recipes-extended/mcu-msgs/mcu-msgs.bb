DESCRIPTION = "Example of minimal publisher/subscriber using rclcpp."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI = "git://git@git.internal:4122/robot/mcu_msgs.git;protocol=ssh;branch=master"
SRCREV = "97fb4ea0cdf81d9e500f208a0042136a39601d03"

inherit ros_distro_jazzy

INSANE_SKIP:${PN}-dev += "dev-elf"
INSANE_SKIP:${PN} += "dev-deps"
RDEPENDS:remove:${PN}-dev = "${PN}"

DEPENDS = "ament-cmake-native std-msgs rosidl-default-generators-native rosidl-default-runtime-native"


S = "${WORKDIR}/git"

inherit ros_ament_cmake

