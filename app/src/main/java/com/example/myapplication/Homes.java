package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Homes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }


    public void onBackPressed(){
        this.finishAffinity();
    }

}
