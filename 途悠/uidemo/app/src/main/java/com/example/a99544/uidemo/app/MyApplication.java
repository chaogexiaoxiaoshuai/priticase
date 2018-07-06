package com.example.a99544.uidemo.app;

import android.app.Application;
import android.content.Context;

import com.avos.avoscloud.AVOSCloud;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;

/**
 * Created by 99544 on 2017/10/22.
 */

public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        LitePal.initialize(mContext);
        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"tNWwHpuGf47IWLdS5wgjTkaX-gzGzoHsz","QgmECj3AEsup56uWlOAMP4zi");
    }

    public static Context getContext(){
        return mContext;
    }
}
