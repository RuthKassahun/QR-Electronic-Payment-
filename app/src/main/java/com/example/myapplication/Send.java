package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class Send extends AppCompatActivity {

    private LinearLayout viaAccount,viaQR;
    private Button continuebtn,cancelbtn;
    Animation fade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        viaAccount = findViewById(R.id.qrSend);
        viaQR = findViewById(R.id.viaQR);
        continuebtn = findViewById(R.id.btnContinue);
        cancelbtn = findViewById(R.id.bthCancel);

        continuebtn.setAlpha(0);
        cancelbtn.setAlpha(0);

        fade = AnimationUtils.loadAnimation(this,R.anim.fade);

        viaAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                continuebtn.setAlpha(1);
                cancelbtn.setAlpha(1);
            continuebtn.startAnimation(fade);
            cancelbtn.startAnimation(fade);


            }

        });

        viaQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                continuebtn.setAlpha(1);
                cancelbtn.setAlpha(1);
                continuebtn.startAnimation(fade);
                cancelbtn.startAnimation(fade);


            }

        });


        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Send.this,SendViaAccount.class);
                startActivity(i);

            }
        });


        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               cancelbtn.setAlpha(1);
               cancelbtn.startAnimation(fade);
            }
        });


    }
}
