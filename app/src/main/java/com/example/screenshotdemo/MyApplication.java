package com.example.screenshotdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by xuwenbin on 2021/6/17 3:30 下午.
 */
public class MyApplication extends Application {
    public static Context context;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        context = base;
    }
}
