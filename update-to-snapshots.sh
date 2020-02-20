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
cd processor-apps-generator/splitter-processor-apps-generator
update_versions

#processor container
update_container

#sink apps
cd sink-apps-generator/rabbit-sink-apps-generator
update_versions

cd log-sink-apps-generator
update_versions

#sink container
update_container

#source apps

cd source-apps-generator/time-source-apps-generator
update_versions

cd jdbc-source-apps-generator
update_versions

cd http-source-apps-generator
update_versions

#source container
update_container

#root container
./mvnw versions:set -DnewVersion=3.0.0.BUILD-SNAPSHOT -DgenerateBackupPoms=false
