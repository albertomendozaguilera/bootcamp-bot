#!/bin/bash

git diff --name-only HEAD HEAD~1 | xargs echo | grep teamdata.json
if [ $? -eq 0 ] ; then
	curl -H "Content-Type: application/json" --data @src/data/teamdata.json https://telegram-winbot.herokuapp.com/data
fi
