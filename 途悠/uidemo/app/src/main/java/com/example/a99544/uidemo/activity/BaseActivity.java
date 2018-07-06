package com.example.a99544.uidemo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.a99544.uidemo.collector.ActivityCollector;

/**
 * Created by 99544 on 2017/5/9/009.
 * 基础类，提供任务管理等功能
 */

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        Window window = getWindow();
//设置透明状态栏,这样才能让 ContentView 向上
        //window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

//需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//设置状态栏颜色
        window.setStatusBarColor(Color.rgb(255, 204, 39));
        ActivityCollector.addActivites(this);

    }

    @Override
    protected void onDestroy() {
        ActivityCollector.removeActivity(this);
        super.onDestroy();
    }
}
