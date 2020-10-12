package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.hanks.passcodeview.PasscodeView;

public class loginActivity extends AppCompatActivity {

    PasscodeView passcodeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        passcodeView = findViewById(R.id.passcode_view);

        passcodeView.setPasscodeLength(4).setLocalPasscode("1234").setListener(new PasscodeView.PasscodeViewListener() {
            @Override
            public void onFail() {
                //If password

                Toast.makeText(getApplicationContext(),"password is Incorrect",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onSuccess(String number) {


                Intent i = new Intent(loginActivity.this, Homes.class);
                    startActivity(i);
            }
        });


    }
}
