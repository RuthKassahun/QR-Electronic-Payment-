package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Send extends AppCompatActivity {
    private Button scan_btn;
    private LinearLayout viaAccount,viaQR;
    private Button continuebtn,cancelbtn;
    Animation fade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        scan_btn = (Button) findViewById(R.id.scan_btn);
        final Activity activity = this;
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });

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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "You Cancelled the Scanning", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else
            super.onActivityResult(requestCode, resultCode, data);
    }
}
