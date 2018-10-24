package com.example.daksh.jobscheduler;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static String username = "Daksh";
    public static String longitude = "78.5695571899414";
    public static String latitude = "17.546300888061523";
    public final static String url = "http://172.16.224.224:8000/api/location/";

    public static Context mContext;
    private RequestQueue mQueue;
    public TextView mTextView;

    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();
        mQueue  = Volley.newRequestQueue(mContext);
        mTextView = (TextView)findViewById(R.id.textView);
    }

    public void scheduleJob(View view) {
        ComponentName componentName = new ComponentName(this, ExampleJobService.class);
        JobInfo info = new JobInfo.Builder(123, componentName)
                .setPersisted(true)
                .setPeriodic(15 * 60 * 1000)
                .build();

        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        assert scheduler != null;
        int resultCode = scheduler.schedule(info);
        if(resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.d(TAG, "Job Scheduled Successfuly");
        }else {
            Log.d(TAG, "Job Scheduling Failed");
        }

    }

    public void cancelJob(View view) {
        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        assert scheduler != null;
        scheduler.cancel(123);
        Log.d(TAG, "Job Cancelled");
    }

    private static Map<String, String> checkParams(Map<String, String> map){
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pairs = (Map.Entry<String, String>)it.next();
            if(pairs.getValue()==null){
                map.put(pairs.getKey(), "");
            }
        }
        return map;
    }

    @SuppressLint("StaticFieldLeak")
    public void sendDataToServer(){


        new AsyncCaller().execute();

    }

    public static void getServerResponse(Map<String,String> json){

        final Map<String, String> json_value= json;

        RequestQueue queue = MySingleton.getInstance(mContext.getApplicationContext()).
                getRequestQueue();


        StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() {
                return checkParams(json_value);
            }
        };


        MySingleton.getInstance(mContext).addToRequestQueue(MyStringRequest);
    }

    public void setUsername(View view){
        username = mTextView.getText().toString();
    }
}
