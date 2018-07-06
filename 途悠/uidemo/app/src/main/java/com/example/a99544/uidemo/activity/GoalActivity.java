package com.example.a99544.uidemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a99544.uidemo.R;

import org.w3c.dom.Text;

/*
选择旅游主题
 */
public class GoalActivity extends BaseActivity implements View.OnClickListener{

    public static final String THEME_ID = "theme_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        TextView title = (TextView)findViewById(R.id.title) ;
        title.setText("选择主题");

        LinearLayout ll1 = (LinearLayout) findViewById(R.id.circle_1);
        LinearLayout ll2 = (LinearLayout) findViewById(R.id.circle_2);
        LinearLayout ll3 = (LinearLayout) findViewById(R.id.circle_3);
        LinearLayout ll4 = (LinearLayout) findViewById(R.id.circle_4);
        LinearLayout ll5 = (LinearLayout) findViewById(R.id.circle_5);
        LinearLayout ll6 = (LinearLayout) findViewById(R.id.circle_6);

        ll1.setOnClickListener(this);
        ll2.setOnClickListener(this);
        ll3.setOnClickListener(this);
        ll4.setOnClickListener(this);
        ll5.setOnClickListener(this);
        ll6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = 0;
        switch(v.getId()){
            case R.id.circle_1: id = 1;break;
            case R.id.circle_2: id = 2;break;
            case R.id.circle_3: id = 3;break;
            case R.id.circle_4: id = 4;break;
            case R.id.circle_5: id = 5;break;
            case R.id.circle_6: id = 6;break;
        }
        Intent intent = new Intent(GoalActivity.this,SelectSpotActivity.class);
        intent.putExtra(SelectSpotActivity.TYPE,1);
        intent.putExtra(THEME_ID,id);
        startActivity(intent);
    }
}
