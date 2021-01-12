package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.MediaRouteButton;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    Button callSignUp;
    Button getin;
    TextInputLayout logUsername, logPassword;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        logUsername = findViewById(R.id.username);
        logPassword = findViewById(R.id.password);
        progressBar = findViewById(R.id.progress_bar);

        progressBar.setVisibility(View.GONE);

        getin = findViewById(R.id.go_btn);

        callSignUp = findViewById(R.id.signup_screen);


        getin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent = new Intent(Login.this, UserProfile.class);
                //startActivity(intent);
                loginUser(v);
            }
        });
        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp2.class);
                startActivity(intent);
            }
        });
    }

<<<<<<< HEAD
=======
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

>>>>>>> 8cbfdb980195638bb94092a332b9f72d4dc8bddd
    private boolean validateUserName() {
        String val = logUsername.getEditText().getText().toString();

        if (val.isEmpty()) {
            logUsername.setError("This field can not be left empty");
            return false;
        } else {
            logUsername.setError(null);
            logUsername.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = logPassword.getEditText().getText().toString();

        if (val.isEmpty()) {
            logPassword.setError("This field can not be left empty");
            return false;
        } else {
            logPassword.setError(null);
            logPassword.setErrorEnabled(false);
            return true;
        }
    }

    public void loginUser(View view) {

        if (!validateUserName() | !validatePassword()) {
            return;
        } else {
            isUser();
        }

    }

    private void isUser() {

        //Intent intent = new Intent(getApplicationContext(), UserProfile.class);
        // startActivity(intent);

        progressBar.setVisibility(View.VISIBLE);

        final String userEnteredUsername = logUsername.getEditText().getText().toString().trim();
        final String userEnteredPassword = logPassword.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    logUsername.setError(null);
                    logPassword.setErrorEnabled(false);

                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);

                    if (passwordFromDB.equals(userEnteredPassword)) {

                        logUsername.setError(null);
                        logUsername.setErrorEnabled(false);

                        String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                        String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
                        String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);
                        String phoneNoFromDB = dataSnapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
                        String balanceFromDB = dataSnapshot.child(userEnteredUsername).child("balance").getValue(String.class);
                        Intent intent = new Intent(getApplicationContext(), UserProfile.class);

                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("username", usernameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("phoneNo", phoneNoFromDB);
                        intent.putExtra("password", passwordFromDB);
                        intent.putExtra("balance", balanceFromDB);

                        startActivity(intent);
                        progressBar.setVisibility(View.GONE);

                    } else {
                        progressBar.setVisibility(View.GONE);
                        logPassword.setError("Wrong Password");
                        logPassword.requestFocus();
                    }
                } else {
                    progressBar.setVisibility(View.GONE);
                    logUsername.setError("No such User exists");
                    logUsername.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}