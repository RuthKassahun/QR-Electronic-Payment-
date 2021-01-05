package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class Recieve extends AppCompatActivity {
    String TAG="GenerateQrCode";
    String inputvalue;
    EditText edttxt;
    ImageView qrimg;
    private LinearLayout qrcgen;
    QRGEncoder qrgEncoder;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        qrimg=(ImageView)findViewById(R.id.qrc);
        edttxt=(EditText)findViewById(R.id.edittext);

        qrcgen = findViewById(R.id.qrcgen);

        qrcgen.setClickable(true);


        qrcgen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputvalue=edttxt.getText().toString().trim();
                if(inputvalue.length()>0){
                    WindowManager manager=(WindowManager)getSystemService(WINDOW_SERVICE);
                    Display display=manager.getDefaultDisplay();
                    Point point=new Point();
                    display.getSize(point);
                    int width=point.x;
                    int height=point.y;
                    int smallerdimension=width<height ? width:height;
                    smallerdimension=smallerdimension*3/4;
                    qrgEncoder=new QRGEncoder(inputvalue,null,QRGContents.Type.TEXT,smallerdimension);
                    bitmap = qrgEncoder.getBitmap();
                    qrimg.setImageBitmap(bitmap);
                }else{
                    edttxt.setError("Required");
                }
            }
        });
    }
}
