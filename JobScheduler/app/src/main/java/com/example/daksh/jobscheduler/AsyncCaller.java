package com.example.daksh.jobscheduler;

import android.os.AsyncTask;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class AsyncCaller extends AsyncTask<Void, Void, Void>{

    @Override
    protected Void doInBackground(Void... voids) {
        final Map<String, String> json = formatDataAsJSON();
        MainActivity.getServerResponse(json);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    private Map<String, String> formatDataAsJSON(){

        Map<String, String> params = new HashMap<String, String>();
        params.put("username", MainActivity.username);
        params.put("lng", MainActivity.longitude);
        params.put("lat", MainActivity.latitude);
        return params;

    }
}
