package com.coderefer.androidsplashscreenexample;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.view.View;

/**
 * Created by Pegasus on 19-03-2016.
 */
public class Input extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void On_click(View view){
       Intent intent = new Intent(Input.this,Camera_Input.class);
        startActivity(intent);
    }

    public void manual(View view){
        Intent intent = new Intent(Input.this,Manual.class);
        startActivity(intent);
    }
}


