package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Homes extends AppCompatActivity {

    private LinearLayout sendLayout;
    private LinearLayout recieveLayout;
    private LinearLayout transactionLayout;
    private LinearLayout accountLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        sendLayout = findViewById(R.id.sendLayout);
        recieveLayout = findViewById(R.id.recieveLayout);
        transactionLayout = findViewById(R.id.transactionLayout);
        accountLayout = findViewById(R.id.accountlayout);

        sendLayout.setClickable(true);
        recieveLayout.setClickable(true);
        transactionLayout.setClickable(true);
        accountLayout.setClickable(true);
        



        sendLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(Homes.this,Send.class);
                startActivity(i);

            }
        });

        recieveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Homes.this, Recieve.class);
                startActivity(i);

            }
        });

        transactionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Homes.this,ChooseAccount.class);
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
