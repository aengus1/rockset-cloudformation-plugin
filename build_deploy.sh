#!/bin/bash

if ./gradlew build; then
  echo "Gradle build task succeeded. Deploying..." >&2
  sls deploy -v

else
  echo "Gradle task failed. Aborting" >&2
fi