    package com.example.daksh.myfirstmap;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import static com.example.daksh.myfirstmap.MapActivity.*;


    public class MainActivity extends AppCompatActivity {

    //vars
    public double lattitude = 0;
    public double longitude = 0;
    private TextView textView;

    private static final String TAG = "MainActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(isServiceOK()){
            init();
        }
    }

    private void init(){
        Button btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean isServiceOK(){
        Log.d(TAG," isServiceOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);

        if(available == ConnectionResult.SUCCESS){
            //everything is fine and the user can make map requests
            Log.d(TAG, "isServiceOK: Google Play Services is working");
            return true;
        }

        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //an error occured but we can resolve it
            Log.d(TAG,"isServiceOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }

        else
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();

        return false;
    }

    public void display_long_lat(View view){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        longitude = prefs.getFloat(LONGITUDE, 0);
        lattitude = prefs.getFloat(LATTITUDE,0);

        if(longitude != 0){
            if(lattitude != 0){
                textView.setText("Lattitude : " + lattitude + "\nLongitude = " + longitude);
            }
        }
    }


}
