#!/bin/sh

function update_versions() {
  rm -rf apps
  ./mvnw versions:set -DnewVersion=3.0.0.BUILD-SNAPSHOT -DgenerateBackupPoms=false
  ./mvnw versions:update-parent -DparentVersion=3.0.0.BUILD-SNAPSHOT -DallowSnapshots=true -DgenerateBackupPoms=false

  lines=$(find . -type f -name pom.xml | xargs grep SNAPSHOT | wc -l)
  if [ $lines -eq 0 ]; then
    echo "All updated"
  else
    echo "Snapshots found. Aborting the updates."
  fi
  cd ..
}

function update_container() {
  ../mvnw versions:set -DnewVersion=3.0.0.BUILD-SNAPSHOT -DgenerateBackupPoms=false
  cd ..
}

#processor apps
cd processor/splitter-processor
update_versions
cd filter-processor
update_versions
cd transform-processor
update_versions

#processor container
update_container

#sink apps
cd sink/rabbit-sink
update_versions
cd mongodb-sink
update_versions
cd log-sink
update_versions
cd jdbc-sink
update_versions
cd counter-sink
update_versions
cd cassandra-sink
update_versions

#sink container
update_container

#source apps

cd source/time-source
update_versions

cd jdbc-source
update_versions

cd http-source
update_versions

cd mongodb-source
update_versions

#source container
update_container

#root container
./mvnw versions:set -DnewVersion=3.0.0.BUILD-SNAPSHOT -DgenerateBackupPoms=false
