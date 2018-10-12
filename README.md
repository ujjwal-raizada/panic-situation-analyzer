# Panic-Situation-Analyzer

This project aims to build an app to help people during panic situations by escorting them to the nearest safe house.
This project is built as a part of Microsoft's codefundo++ hackathon.




## Team:

1. [Ujjwal Raizada](http://github.com/ujjwalrox)
2. [Daksh Yashlaha](http://github.com/tufty-123)
3. [Varun Parthasarathy](http://github.com/var-ji)


## Idea:

**Panic-Detection:** Any natural disaster often leads to a panic situation in which people end up moving cluelessly. When a certain threshold of people start moving together in a specific area, a panic situation is detected. Using the accelerometer and location detection feature of smartphones, we detect a panic situation and notify all nearby users in a specific radius of the same.

**Disaster-Prediction:** After successfully detecting a panic situation, we detect the type of disaster and inform a large group of people living nearby about the probable disaster. This will help people to prepare some countermeasures in advance so as to minimize loss of life.

This detection will be based on:
1. Location of panic situation with proximity to disaster prone areas.
2. Location of panic situation - if panic is created near coastlines, probable disasters include hurricanes, tsunami.
3. Using open source weather forecasting APIs. 
 
**Early-Warning-System:**  Immediately after detection of panic, nearby people in a large area are alerted. Also they are provided real time help in the form of escape routes and safety tips. This app will provide a real time map displaying the path to nearby safe zones like open grounds, hospitals, police stations. Even if internet is not available, an offline downloaded version of the map will be used.

## Tools:

1. Android Studio
2. Django Web Framework
3. Visual Studio Code
4. More