package com.example.a99544.uidemo.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a99544.uidemo.R;
import com.example.a99544.uidemo.adapter.MainFragmentPagerAdapter;
import com.example.a99544.uidemo.fragment.OneFragment;
import com.example.a99544.uidemo.fragment.THREEFragment;
import com.example.a99544.uidemo.fragment.TWOFragment;

import java.util.ArrayList;
import java.util.List;

import static android.os.SystemClock.sleep;

/*
启动界面
 */

public class SplashActivity extends FragmentActivity {

    private ViewPager mPager;//页卡内容
    private ArrayList<Fragment> listViews; //Tab页面列表
    OneFragment oneFragment=new OneFragment();
    TWOFragment twoFragment=new TWOFragment();
    THREEFragment thrFragment=new THREEFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        //InitTextView();
        InitViewPager() ;
    }
    /**
     * 初始化ViewPager
     */
    private void InitViewPager() {
        mPager = (ViewPager) findViewById(R.id.vPager);
        listViews = new ArrayList<Fragment>();
        listViews.add(oneFragment);
        listViews.add(twoFragment);
        listViews.add(thrFragment);
        FragmentManager fragmentManager =this.getSupportFragmentManager();
        mPager.setAdapter(new MainFragmentPagerAdapter(fragmentManager,listViews));
        mPager.setCurrentItem(0);

    }

}
