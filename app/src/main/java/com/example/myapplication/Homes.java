package com.example.myapplication;

import androidx.annotation.StringDef;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
<<<<<<< HEAD
=======
import androidx.drawerlayout.widget.DrawerLayout;
>>>>>>> 8cbfdb980195638bb94092a332b9f72d4dc8bddd

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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Homes extends AppCompatActivity {

<<<<<<< HEAD
    private CardView sendLayout;
    private LinearLayout topperLayout;
    private CardView transactionLayout;
    private CardView accountLayout;
=======
    private CardView accountLayout;
    private LinearLayout receiveLayout;
    private LinearLayout sendLayout;
    private CardView tn001;
    private CardView tn002;
    private ImageButton hamburgermenu;
    Dialog myDialog;
    TextView balance;
>>>>>>> 8cbfdb980195638bb94092a332b9f72d4dc8bddd

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

<<<<<<< HEAD
        sendLayout =  findViewById(R.id.sendLayout);
        topperLayout = findViewById(R.id.topperLayout);
        transactionLayout = findViewById(R.id.transactionLayout);
        accountLayout = findViewById(R.id.accountlayout);

        //sendLayout.setClickable(true);
        topperLayout.setClickable(true);
        //transactionLayout.setClickable(true);
        //accountLayout.setClickable(true);
        
=======
        balance = findViewById(R.id.balance);
        balance.setText("0.00");

        accountLayout = findViewById(R.id.accountlayout);

        accountLayout.setClickable(true);
>>>>>>> 8cbfdb980195638bb94092a332b9f72d4dc8bddd

        myDialog = new Dialog(this);
        receiveLayout = findViewById(R.id.receiveLayout);
        sendLayout = findViewById(R.id.sendLayout);
        tn001 = findViewById(R.id.tn001);
        tn002 = findViewById(R.id.tn002);
        hamburgermenu = findViewById(R.id.hamburger_menu);

        receiveLayout.setClickable(true);
        sendLayout.setClickable(true);
        tn001.setClickable(true);
        tn002.setClickable(true);


        hamburgermenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Homes.this, hamburgermenu.class);
                startActivity(i);

                overridePendingTransition(R.anim.animation_leave,R.anim.animation_enter);
            }
        });



        accountLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Homes.this, Account.class);
                startActivity(i);
            }
        });

<<<<<<< HEAD
        topperLayout.setOnClickListener(new View.OnClickListener() {
=======

        receiveLayout.setOnClickListener(new View.OnClickListener() {
>>>>>>> 8cbfdb980195638bb94092a332b9f72d4dc8bddd
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Homes.this, Recieve.class);
                startActivity(i);

            }
        });

        sendLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Homes.this, Send.class);
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

    public void onBackPressed() {
        this.finishAffinity();
    }


}
