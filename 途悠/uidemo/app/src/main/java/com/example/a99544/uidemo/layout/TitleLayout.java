package com.example.a99544.uidemo.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.a99544.uidemo.R;
import com.example.a99544.uidemo.collector.ActivityCollector;

import static com.example.a99544.uidemo.R.id.back;

/**
 * Created by 99544 on 2017/5/9/009.
 */

public class TitleLayout extends RelativeLayout {

    public TitleLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button back=(Button)findViewById(R.id.back);
        Button search=(Button)findViewById(R.id.serach);
        TextView title=(TextView)findViewById(R.id.title);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.activities.get(ActivityCollector.activities.size()-1).finish();
            }
        });

        ProgressBar progressBar=(ProgressBar)findViewById(R.id.progressbar);
        progressBar.setProgress(ActivityCollector.activities.size()-1);
    }


}


