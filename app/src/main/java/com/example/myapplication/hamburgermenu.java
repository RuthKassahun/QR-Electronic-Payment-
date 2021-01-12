package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.textfield.TextInputLayout;

public class hamburgermenu extends AppCompatActivity {

    ImageButton backtohome;
    CardView AcceptDonations;
    CardView Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburgermenu);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        backtohome = findViewById(R.id.backtohome);
        AcceptDonations = findViewById(R.id.acceptdonations);
        Logout = findViewById(R.id.logout);


        backtohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(hamburgermenu.this, Homes.class);
                startActivity(i);
            }
        });

        AcceptDonations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(hamburgermenu.this, staticQR.class);
                startActivity(i);
            }
        });

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(hamburgermenu.this, Login.class);
                startActivity(i);
                finish();
            }
        });

    }


}