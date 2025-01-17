SUMMARY = "Small console image for Orange Pi Zero"
IMAGE_LINGUAS = "en-us"

inherit core-image

CORE_OS = " \
  u-boot-opi \
  openssh openssh-keygen \
  kernel-modules \
"

EXTRA_TOOLS_INSTALL = " \
  mtd-utils \
"

IMAGE_INSTALL += " \
  ${CORE_OS} \
  ${EXTRA_TOOLS_INSTALL} \
  linux-firmware-ath9k \
  libuv \
  libpcap \
  libpcap-dev \
  libnl \
  libnl-dev \
  wireless-tools \
  libiw \
  libiw-dev \
  dlib \
"

IMAGE_FEATURES += "package-management"
