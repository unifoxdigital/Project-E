package com.hihasan.e_traceability.globe;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hihasan.e_traceability.globe.animal.AnimalDetails;
import com.hihasan.e_traceability.globe.commercial.Commercial;
import com.hihasan.e_traceability.globe.harvest.HarvestDetails;
import com.hihasan.e_traceability.globe.monitoring.Monitoring;
import com.hihasan.e_traceability.globe.pound.PoundDetails;
import com.hihasan.e_traceability.globe.store.Store;
import com.hihasan.e_traceability.globe.utils.Value;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_pound) {
            // Handle the camera action
            Intent i=new Intent(MainActivity.this, PoundDetails.class);
            startActivity(i);
        }

        else if (id == R.id.nav_details) {
            Intent i=new Intent(MainActivity.this, AnimalDetails.class);
            startActivity(i);

        }

        else if (id == R.id.nav_monitoring) {
            Intent i=new Intent(MainActivity.this, Monitoring.class);
            startActivity(i);

        }

        else if (id == R.id.nav_commercial) {
            Intent i=new Intent(MainActivity.this, Commercial.class);
            startActivity(i);

        }

        else if (id == R.id.nav_harvest) {
            Intent i=new Intent(MainActivity.this, HarvestDetails.class);
            startActivity(i);

        }

        else if (id == R.id.nav_store) {
            Intent i=new Intent(MainActivity.this, Store.class);
            startActivity(i);

        }


        else if (id == R.id.nav_signout) {
            final Dialog dialog=new Dialog(context);
            dialog.setContentView(R.layout.activity_custom);
            dialog.setTitle("Title..");

            AppCompatTextView t=(AppCompatTextView) dialog.findViewById (R.id.name);
            t.setText(Value.sign_out_text);

            AppCompatButton confirm=(AppCompatButton) dialog.findViewById (R.id.confirm);
            AppCompatButton cancel= (AppCompatButton) dialog.findViewById (R.id.cancel);

            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"This will take Sinin Page",Toast.LENGTH_SHORT).show();
                }
            });

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        }

        else if (id == R.id.nav_exit) {
            final Dialog dialog=new Dialog(context);
            dialog.setContentView(R.layout.activity_custom);
            dialog.setTitle("Title..");

            AppCompatTextView t=(AppCompatTextView) dialog.findViewById (R.id.name);
            t.setText(Value.exit_text);

            AppCompatButton confirm=(AppCompatButton) dialog.findViewById(R.id.confirm);
            AppCompatButton cancel=(AppCompatButton) dialog.findViewById (R.id.cancel);

            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.exit(0);
                }
            });

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}