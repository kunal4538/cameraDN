package com.example.aggarwals.camera;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_IMGAGE_CAPTURE = 188;
    ImageView imgview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton button=(ImageButton) findViewById(R.id.button);
        imgview=(ImageView)findViewById(R.id.imgview);

        if(!hascamera())
            button.setEnabled(false);

    }

    private boolean hascamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);

    }

    public void launchCamera(View view){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
       this.startActivityForResult(i, REQUEST_IMGAGE_CAPTURE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_IMGAGE_CAPTURE && resultCode==RESULT_OK){
            Bundle extras=data.getExtras();
            Bitmap pic= (Bitmap) extras.get("data");
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("images", pic);
            startActivity(intent);

        }
    }
}
