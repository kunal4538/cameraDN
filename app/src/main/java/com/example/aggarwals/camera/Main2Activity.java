package com.example.aggarwals.camera;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        image=(ImageView)findViewById(R.id.photo);
        Bundle b= getIntent().getExtras();
        int pic= b.getInt("pic");
        image.setImageResource(pic);
    }
}
