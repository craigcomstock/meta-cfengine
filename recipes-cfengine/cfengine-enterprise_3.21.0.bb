#
# Copyright (C) 2023 Northern.tech AS
#
SUMMARY = "CFEngine Enterprise plugin"

DESCRIPT = "CFEngine Enterprise provides advanced reporting features."

HOMEPAGE = "https://cfengine.com"

LICENSE = "Proprietary"
LICENSE_FLAGS = "commercial"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fixme"

#SRC_URI = "https://cfengine.com/blog/2023/cfengine-enterprise-alpha-for-yocto/${PACKAGE_ARCH}/cfengine-enterprise.so;nobranch=1
SRC_URI = "file:///home/craig/cfengine-enterprise-yocto-dist/${PACKAGE_ARCH}/cfengine-enterprise.so"

export EXPLICIT_VERSION="${PV}"

DEPENDS = "cfengine"

do_install() {
  cp cfengine-enterprise.so ${D}/var/cfengine/lib
}
FILES:${PN} = "/var/cfengine/lib/cfengine-enterprise.so"
