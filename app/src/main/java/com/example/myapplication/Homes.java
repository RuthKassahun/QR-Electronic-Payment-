package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Homes extends AppCompatActivity {

    private CardView sendLayout;
    private LinearLayout topperLayout;
    private CardView transactionLayout;
    private CardView accountLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        sendLayout =  findViewById(R.id.sendLayout);
        topperLayout = findViewById(R.id.topperLayout);
        transactionLayout = findViewById(R.id.transactionLayout);
        accountLayout = findViewById(R.id.accountlayout);

        //sendLayout.setClickable(true);
        topperLayout.setClickable(true);
        //transactionLayout.setClickable(true);
        //accountLayout.setClickable(true);
        



        sendLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(Homes.this,Send.class);
                startActivity(i);

            }
        });

        topperLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Homes.this, Recieve.class);
                startActivity(i);

            }
        });

        transactionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Homes.this,Transaction.class);
                startActivity(i);
            }
        });


        accountLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Homes.this, Account.class);
                startActivity(i);
            }
        });

    }


    public void onBackPressed(){
        this.finishAffinity();
    }


}
