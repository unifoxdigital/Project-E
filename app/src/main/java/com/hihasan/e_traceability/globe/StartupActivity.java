package com.hihasan.e_traceability.globe;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import com.hihasan.e_traceability.globe.utils.Value;

public class StartupActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        //Thread Handler for 5 sec.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkConnection();
            }
        }, Value.APP_LOADING_TIME);
        
    }

    //Check connection Here
    private void checkConnection()
    {
        if(isOnline())
        {
            Toast.makeText(getApplicationContext(), "You are connected to Internet", Toast.LENGTH_SHORT).show();

            final Intent mainIntent = new Intent(StartupActivity.this, LoginActivity.class);
            StartupActivity.this.startActivity(mainIntent);
            StartupActivity.this.finish();
        }

        else
        {
            Toast.makeText(getApplicationContext(), "You are not connected to Internet", Toast.LENGTH_SHORT).show();
//            final Intent mainIntent = new Intent(StartupActivity.this, NoInternet.class);
//            startActivity(mainIntent);
//            finish();
        }
    }

    //Internet Connection
    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }
}
