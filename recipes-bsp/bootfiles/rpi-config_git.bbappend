DISABLE_SPLASH = "1"

# ttyAMA2: ROS
RPI_EXTRA_CONFIG:append = "dtoverlay=uart2\n"

# ttyAMA3: Log
RPI_EXTRA_CONFIG:append = "dtoverlay=uart3\n"

# ttyACM5: LIDAR
RPI_EXTRA_CONFIG:append = "dtoverlay=uart5\n"

RPI_EXTRA_CONFIG:append = "dtoverlay=gpio-shutdown,gpio_pin=3\n"
RPI_EXTRA_CONFIG:append = "dtoverlay=gpio-led,gpio=18,trigger=cpu\n"
ENABLE_GPIO_SHUTDOWN = "16"

# PWM signal for lidar motor
RPI_EXTRA_CONFIG:append = "dtoverlay=pwm,pin=19,func=2\n"

# fan support
RPI_EXTRA_CONFIG:append = "dtoverlay=gpio-fan,gpiopin=14,temp=55000\n"