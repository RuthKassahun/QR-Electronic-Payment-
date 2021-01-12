package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class firstActivity extends AppCompatActivity {

    private Button SignupButton;
        private Button LoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        SignupButton = findViewById(R.id.SignupButton);
        LoginButton = findViewById(R.id.LoginButton);

        SignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignupActivity();

            }


        });

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginActivity();
            }
        });

    }
        public void openSignupActivity(){

            Intent i = new Intent(this,signUp.class);
                startActivity(i);
        }

        public void openLoginActivity(){

            Intent i = new Intent(firstActivity.this, loginActivity.class);
            startActivity(i);
        }

    }

