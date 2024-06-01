SUMMARY = "Didistro command line tools"
LICENSE = "CLOSED"

SRC_URI = " \
    git://github.com/yuvaldd9/didistro-tools.git;protocol=git;branch=master \
    file://current_side \
    file://next_boot_side \
    file://reboot_counter \
"

S = "${WORKDIR}/git"

SRCREV = "ae6927f2fa0de1a14d409272b3bfd91da8bdd516"

inherit python_poetry_core deploy

do_deploy() {
    bbplain AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa
    bbplain ${DEPLOYDIR}
    bbplain BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBbb
    install -d ${DEPLOYDIR}/didistro
    install -m 0644 ${WORKDIR}/current_side ${DEPLOYDIR}/didistro
    install -m 0644 ${WORKDIR}/next_boot_side ${DEPLOYDIR}/didistro
    install -m 0644 ${WORKDIR}/reboot_counter ${DEPLOYDIR}/didistro
}

do_deploy[dirs] = "${DEPLOYDIR}/didistro"

addtask deploy after do_install