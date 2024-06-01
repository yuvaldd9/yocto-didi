DESCRIPTION="Establish overlay filesystem on specified directories"
LICENSE="CLOSED"

SRC_URI = " \
    file://overlay \
"

RDEPENDS:{PN} += " \
    python3-didistro-tools \
"

INITSCRIPT_NAME = "overlay"
INITSCRIPT_PARAMS= "defaults"


OVERLAY_DIRS = "/etc /var"

do_install() {
    # Mkdir the overlay root directory
    install -d ${D}/overlay

    # Install the initscript
    install -d ${D}${INIT_D_DIR}
    sed "s|@@OVERLAY_DIRS@@|${OVERLAY_DIRS}|g" ${WORKDIR}/${INITSCRIPT_NAME} > ${D}${INIT_D_DIR}/${INITSCRIPT_NAME}
    chmod +777 ${D}${INIT_D_DIR}/${INITSCRIPT_NAME}
}

FILES:${PN} += "/overlay"

inherit update-rc.d
