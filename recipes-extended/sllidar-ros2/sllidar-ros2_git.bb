inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "The rplidar ros package, support rplidar A2/A1 and A3/S1"
AUTHOR = "Hunter L. Allen <hunterlallen@protonmail.com>"
ROS_AUTHOR = "Slamtec ROS Maintainer <ros@slamtec.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=1e9b2138ef7d1228615d9c7d4538b3db"

ROS_CN = "sllidar_ros2"
ROS_BPN = "sllidar_ros2"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-srvs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-srvs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rplidar_ros-release/archive/release/jazzy/rplidar_ros/2.1.0-4.tar.gz
SRC_URI = "git://github.com/Slamtec/sllidar_ros2.git;branch=main;protocol=https"
SRCREV = "34300099fadfc772965962dec837bf436706188f"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
