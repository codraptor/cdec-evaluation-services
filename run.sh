#!/bin/sh
export JAVA_HOME=/usr1/home/vpratapa/jdk-11
nohup $JAVA_HOME/bin/java -Xmx6000m -DentityExpansionLimit=2147480000 -DtotalEntitySizeLimit=2147480000 -Djdk.xml.totalEntitySizeLimit=2147480000 -jar indexer-0.0.1-SNAPSHOT.jar &
