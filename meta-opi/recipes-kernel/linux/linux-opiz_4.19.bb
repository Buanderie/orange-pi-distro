require linux-opi.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}/${PN}z:"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

COMPATIBLE_MACHINE = "(orange-pi-zero)"

SRCREV = "84df9525b0c27f3ebc2ebb1864fa62a97fdedb7d"

SRC_URI = " \
  git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git;branch=master \
  file://defconfig \
  file://0001-Enable_Spi_Nor_Flash.patch \
  file://ath_patched/ath9k/common-init.c \
  file://ath_patched/ath9k/eeprom_4k.c \
  file://ath_patched/ath9k/eeprom_9287.c \
  file://ath_patched/ath9k/htc_drv_main.c \
  file://ath_patched/ath9k/hw.h \
  file://ath_patched/ath9k/mac.c \
  file://ath_patched/ath9k/mac.h \
  file://ath_patched/regd.c \
  file://mac80211_patched.h \
  file://tx_patched.c \
"

do_configure_prepend() {
    cp ${WORKDIR}/mac80211_patched.h ${WORKDIR}/git/include/net/mac80211.h
    cp ${WORKDIR}/tx_patched.c ${WORKDIR}/git/net/mac80211/tx.c
    cp -R ${WORKDIR}/ath_patched/* ${WORKDIR}/git/drivers/net/wireless/ath/
}

do_configure_append() {

  # Okay, add ath9k (unpatched for now)
  kernel_conf_variable ATH9K m
  kernel_conf_variable ATH9K_HTC m

}
