package com.example.a99544.uidemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.a99544.uidemo.R;

import org.w3c.dom.Text;

/*
根据主题选择景点，即将弃用
 */

public class GoalSpotActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_spot);

        TextView title=(TextView)findViewById(R.id.title);
        title.setText("选择景点");

        TextView next = (TextView)findViewById(R.id.fir_choose_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoalSpotActivity.this,ChuGaoActivity.class);
                startActivity(intent);
            }
        });
    }
}
