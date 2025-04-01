require ${COREBASE}/meta/recipes-core/images/core-image-minimal.bb

SUMMARY = "ROS image containing cyberbot packages"
DESCRIPTION = "${SUMMARY}"

inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_FEATURES += "ssh-server-openssh"


IMAGE_INSTALL:append = " \
    coreutils \
    ros-core \
    tmux \
    mg \
    nano \
    tio \
    cyberbot-bringup \
    esp-rfc2217-server \
    openocd-esp32 \
    wpa-supplicant \
"
