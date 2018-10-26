package com.example.daksh.jobscheduler3;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class AsyncCaller extends AsyncTask<Void, Void, Void>{

    private static final String TAG = "AsyncCaller";

    @Override
    protected Void doInBackground(Void... voids) {
        final Map<String, String> json = formatDataAsJSON();
        Log.d(TAG, "doInBackground: " + json);
        ExampleJobService.getServerResponse(json);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    private Map<String, String> formatDataAsJSON(){

        Map<String, String> params = new HashMap<String, String>();
        params.put("username", ExampleJobService.username);
        params.put("lng", ExampleJobService.latitude);
        params.put("lat", ExampleJobService.latitude);
        return params;

    }
}

