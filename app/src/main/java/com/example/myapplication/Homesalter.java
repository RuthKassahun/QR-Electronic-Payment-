package com.example.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Homesalter extends AppCompatActivity {

    private LinearLayout receiveLayout;
    private LinearLayout sendLayout;
    private CardView tn001;
    private CardView tn002;
    Dialog myDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homesalter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        myDialog = new Dialog(this);
        receiveLayout = findViewById(R.id.receiveLayout);
        sendLayout = findViewById(R.id.sendLayout);
        tn001 = findViewById(R.id.tn001);
        tn002 = findViewById(R.id.tn002);

        receiveLayout.setClickable(true);
        sendLayout.setClickable(true);
        tn001.setClickable(true);
        tn002.setClickable(true);



        receiveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Homesalter.this, Recieve.class);
                startActivity(i);

            }
        });

        sendLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Homesalter.this, Send.class);
                startActivity(i);

            }
        });

        tn001.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup();
            }
        });

        tn002.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup();
            }
        });




    }

    public void ShowPopup() {

        TextView txtclose;
        Button btnFollow;
        myDialog.setContentView(R.layout.custompopup);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }

}
