`package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Homes extends AppCompatActivity {

    private CardView transactionLayout;
    private CardView accountLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        transactionLayout = findViewById(R.id.transactionLayout);
        accountLayout = findViewById(R.id.accountlayout);


        transactionLayout.setClickable(true);
        accountLayout.setClickable(true);


        transactionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Homes.this,Homesalter.class);
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
