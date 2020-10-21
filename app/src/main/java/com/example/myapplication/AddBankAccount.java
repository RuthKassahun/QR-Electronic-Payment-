package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AddBankAccount extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6,e7,e8,bankname;
    TextView t1,t2,t3,t4,t5,bank;
    Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bank_account);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();



        e1 = findViewById(R.id.et1); //code 1
        e2 = findViewById(R.id.et2); //code 2
        e3 = findViewById(R.id.et3);
        e4 = findViewById(R.id.et4);
        e5 = findViewById(R.id.et5); //name
        e6 = findViewById(R.id.et6); //month
        e7 = findViewById(R.id.et7); //year
        e8 = findViewById(R.id.et8); //cvv
        bankname = findViewById(R.id.bankn); //bank name

        t1 = findViewById(R.id.code);
        t2 = findViewById(R.id.cardHolder);
        t3 = findViewById(R.id.month);
        t4 = findViewById(R.id.year);
        t5 = findViewById(R.id.cvv);
        bank = findViewById(R.id.bankName);

        proceed = findViewById(R.id.proceed);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_down);

                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.r11);
                relativeLayout.setAnimation(animation);

                String code1,code2,code3,code4;

                code1 = e1.getText().toString();
                code2 = e2.getText().toString();
                code3 = e3.getText().toString();
                code4 = e4.getText().toString();

                t1.setText(code1 + "\t\t\t" + code2 + "\t\t\t" + code3 + "\t\t\t" + code4);

                String name, month, year, cvv, bankName;

                name = e5.getText().toString();
                t2.setText(name);
                month = e6.getText().toString();
                t3.setText(month);
                year = e7.getText().toString();
                t4.setText(year);
                cvv = e8.getText().toString();
                t5.setText(cvv);
                bankName = bankname.getText().toString();
                bank.setText(bankName);
            }
        });

    }
}
