# Documentation

## Features
#### Disaster Prediction
The type of disaster in an area is identified by a unique model - by using the movement patterns of panic-struck people in a particular area.
#### Real-time Location Tracking
The app monitors your location at all times, so that if a disaster occurs, you are notified immediately.
#### Locating Panic Epicenters
Computational geometry algorithms are used to accurately determine the center of a disaster-stricken area, allowing us to notify nearby people about the same.
#### Android Interface
Our Android app monitors disaster events, even in the background, and then notifies users about the same. It also displays a handy map, allowing users to know their location and the center of the disaster zone.
#### Web Interface
The web interface allows people to see the current disaster areas over the globe. It also behaves as a registration portal.
#### REST API
The server provides a REST API framework, making it easier to build cross-platform applications.

End-points of REST-API:
1. ```/api/location/``` for sending real-time location to the server.
2. ```/api/paniclocation/``` for sending real-time location during panic situations with less frequency.

We have currently used HTTP for sending location data, but for actual deployment we have to use HTTPS for security.


## How it Works
The Android application constantly monitors the user's position in real time and sends it to the server. When the user starts running, the app informs the server of probable panic.

Once the server receives this data, it applies a computational geometry algorithm to determine the the center of the probable panic and find the relative points w.r.t center.

If this number of users exceeds a certain threshold, the algorithm regards this as an area of interest, and a neural network is used to determine whether it is actually a disaster, and what type of disaster it is, based on the motion the crowd follows.

If it is concluded that it is a disaster, the server sends a message to the app to notify the user within certain threshold radius about the current situation, and displays a map showing the affected areas.

This is how we instantly notify users of probable disasters before-hand, and this gives them a lot more time to prepare and eventually save their lives.


## Open-Source Libraries and Datasets Used
Leaflet maps (<https://leafletjs.com/>) is used to generate the map for the web interface.

The dataset for training our predictive model is derived from Kaggle's dataset for Human Mobility during Natural Disasters (<https://www.kaggle.com/dryad/human-mobility-during-natural-disasters>).


## Further Enhancements
Due to lack of a GPU, we couldn't create a CNN for predicting disasters. We plan to retrain our model using a convolution architecture once we get access to a GPU.

We plan to add features to the map displayed in our Android interface to plot the route to the nearest safe location, based on the type of disaster. In particular, we plan to choose the route that has relatively high traffic on it, as opposed to the routes recommended by general map services. This is because during a disaster of large scale, it is very likely that roads that are not being used _cannot_, in fact, be used, and this reflects in the lack of any traffic on that route.

In addition, we plan to create an interface for rescue services to pinpoint and locate affected people using the location data from the app.

We intend to use open-source weather APIs to cross-check and confirm our disaster predictions. For instance, if our model predicts thunderstorms in a given area, we can confirm it by checking if the weather conditions of that area indicate heavy rains and overcast skies as well.





