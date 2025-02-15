DISABLE_SPLASH = "1"


# ttyAMA0: ESP
# TX PIN: 14
# RX PIN: 15
#ENABLE_UART = "1"
#RPI_EXTRA_CONFIG:append = "dtoverlay=miniuart-bt\n"

# PIN: 16
ENABLE_GPIO_SHUTDOWN = "16"

# ttyAMA2: ROS
# TX PIN: 0
# RX PIN: 1
RPI_EXTRA_CONFIG:append = "dtoverlay=uart2\n"

# ttyAMA3: Log
# TX PIN: 4
# RX PIN: 5
RPI_EXTRA_CONFIG:append = "dtoverlay=uart3\n"

# ttyAMA4: LIDAR
# TX PIN: 8
# RX PIN: 9
RPI_EXTRA_CONFIG:append = "dtoverlay=uart4\n"

# ttyACM5
# TX PIN: 12
# RX PIN: 13
# CTS PIN: 14
# RTS PIN: 15
#RPI_EXTRA_CONFIG:append = "dtoverlay=uart5\n"

