from keras.models import load_model
import numpy as np


def predict(lat, long, hour, minute, sec):
    data = [[lat, long, hour, minute, sec]]
    data = np.vstack(data)
    model = load_model('disaster_model.h5')
    predictions = list(model.predict(data)[0])
    probability = max(predictions)
    disaster = predictions.index(probability)
    if disaster == 0:
        return 'typhoon'
    elif disaster == 1:
        return 'earthquake'
    elif disaster == 2:
        return 'winter_storm'
    elif disaster == 3:
        return 'thunderstorm'
    elif disaster == 4:
        return 'wildfire'

