package com.example.a99544.uidemo.collector;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 99544 on 2017/5/9/009.
 */

public class ActivityCollector {

    public static List<Activity> activities=new ArrayList<Activity>();

    public static void addActivites(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for(Activity activity:activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
