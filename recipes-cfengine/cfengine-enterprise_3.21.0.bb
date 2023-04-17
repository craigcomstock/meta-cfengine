#
# Copyright (C) 2023 Northern.tech AS
#
SUMMARY = "CFEngine Enterprise plugin"

DESCRIPT = "CFEngine Enterprise provides advanced reporting features."

HOMEPAGE = "https://cfengine.com"

# License for CFEngine Enterprise is at https://northern.tech/legal/cfengine-eula and https://northern.tech/legal/cfengine-msla
# using CLOSED here prevents checking of license file checksums
LICENSE = "CLOSED"
LICENSE_FLAGS = "commercial"

SRC_URI = "file:///tmp/cfengine-enterprise-3.21.0.tar.gz"

export EXPLICIT_VERSION="${PV}"

DEPENDS = "cfengine"

do_install() {
  # TODO parameterize platform like MACHINE=bananapi but more specific to say armv7a
  mkdir -p ${D}/var/cfengine/lib
  cp cfengine-enterprise.so ${D}/var/cfengine/lib
}
FILES:${PN} = "/var/cfengine/lib/cfengine-enterprise.so"
# Yocto QA tasks check that shared objects (so files) are not stripped so we must explicitly skip this check for our stripped library.
INSANE_SKIP:${PN} += "already-stripped"
