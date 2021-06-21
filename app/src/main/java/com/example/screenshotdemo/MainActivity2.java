package com.example.screenshotdemo;

import static com.example.screenshotdemo.MainActivity.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        requestPermission();

    }

    /**
     * 请求授权
     */
    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) { //表示未授权时
            //进行授权
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        } else {
            startlistener();
        }
    }


    private void startlistener() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ScreenShotListenManager manager = new ScreenShotListenManager(MyApplication.context);
                manager.setListener(
                        imagePath -> {
                            // do something
                            Toast.makeText(MainActivity2.this,"----触发截屏imagePath:"+imagePath,Toast.LENGTH_LONG).show();
                            Log.d(TAG,"-----------触发截屏imagePath:"+imagePath);
                        }
                );
                manager.startListen();
            }
        }).start();

    }
}